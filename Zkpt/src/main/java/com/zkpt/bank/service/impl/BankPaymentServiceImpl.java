package com.zkpt.bank.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.bank.entity.BankPacketHeadEntity;
import com.zkpt.bank.entity.BankPaymentReqEntity;
import com.zkpt.bank.entity.BankPaymentRespDetailEntity;
import com.zkpt.bank.entity.BankPaymentRespEntity;
import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.bank.entity.BankRespState;
import com.zkpt.bank.service.IBankPaymentService;
import com.zkpt.gas.entity.GasProtocalPackage;
import com.zkpt.gas.entity.GasRespState;
import com.zkpt.middleware.entity.MyConstant;
import com.zkpt.redis.service.IRedisService;
import com.zkpt.util.DateUtils;
import com.zkpt.util.ProtocolTxTUtil;

@Service("bankPaymentService")
@Transactional
public class BankPaymentServiceImpl extends BankServiceImpl implements IBankPaymentService {
    private final static Logger logger = LoggerFactory.getLogger(BankPaymentServiceImpl.class);
    private final static int splitCount = 25;

    @Autowired
    private IRedisService redisService;

    @Override
    public boolean request(BankProtocalPackage bankProtocalPackage) throws Exception {
        // 判断缓存是否为空
        String[] val = bankProtocalPackage.getPacketBody().split(MyConstant.SPLIT1);
        String userNo = val[1];
        String money = val[2];
        String month = val[6];

        List<String> cache = cacheCheck(userNo);

        if (cache == null) {
            errorWrite(BankRespState.ILLEGAL_TRADING.getKey(), MyConstant.ERROR_PAY_001, bankProtocalPackage, splitCount);
            return false;
        }

        if (!monthCheck(cache, month)) {
            errorWrite(BankRespState.NO_ARREARS.getKey(), MyConstant.ERROR_PAY_002, bankProtocalPackage, splitCount);
            return false;
        }

        if (!moneyCheck(cache, userNo, Double.valueOf(money), month)) {
            errorWrite(BankRespState.AMOUNTDIFFER.getKey(), MyConstant.ERROR_PAY_002, bankProtocalPackage, splitCount);
            return false;
        }

        IoSession ioSession = mwFactoryService.createMWClient();
        if (ioSession == null) {
            errorWrite(BankRespState.OTHER_ERROR.getKey(), MyConstant.ERROR_PAY_002, bankProtocalPackage, splitCount);
            return false;
        }

        GasProtocalPackage gasProtocalPackage = protocalTransToGas(bankProtocalPackage, transBody(bankProtocalPackage));
        bankProtocalPackage.setPacketBodyEntity(BankPaymentReqEntity.packaging(bankProtocalPackage.getPacketBody()));
        ioSession.setAttribute("serverSessionKey", bankProtocalPackage);
        ioSession.write(gasProtocalPackage);

        return true;
    }

    @Override
    public boolean response(GasProtocalPackage gasProtocalPackage, BankProtocalPackage serverSessionKey) throws Exception {
        BankPaymentRespEntity bankPaymentResp = new BankPaymentRespEntity();
        BankProtocalPackage protocalPackage = new BankProtocalPackage(); // 实际返回银行的协议包(编码器用)
        BankPacketHeadEntity bankPacketHead = serverSessionKey.getPacketHead();

        bankPaymentResp.setSelf(bankPaymentResp);
        boolean respError = false;
        String errorMsg = "", respondState = "";

        // step1:----------------------组装response响应包----------------------------
        // 01.交易码
        bankPaymentResp.setTransactionCode_s(((BankPaymentReqEntity) serverSessionKey.getPacketBodyEntity()).getTransactionCode_s());
        bankPaymentResp.setTransactionCode(ProtocolTxTUtil.strToCharArray(bankPaymentResp.getTransactionCode_s()));

        // 02.响应码
        switch (GasRespState.getEnumByKey(gasProtocalPackage.getPacketHead().getRespondState_s())) {
        case SUCESS:// 成功的响应码
            bankPaymentResp.setResponseCode_s(BankRespState.TRADE_SUCESS.getKey());
            bankPaymentResp.setResponseCode(ProtocolTxTUtil.strToCharArray(BankRespState.TRADE_SUCESS.getKey()));
            break;
        case FAIL_DETAIL:// 查询失败（具体见返回内容）
            if (gasProtocalPackage.getPacketBody().indexOf(MyConstant.GC_0102_FAIL_MESSAGE_001) != -1) {
                errorMsg = MyConstant.GC_0102_FAIL_MESSAGE_001;
                respondState = BankRespState.ALREADY_PAID.getKey();
            } else if (gasProtocalPackage.getPacketBody().indexOf(MyConstant.GC_0102_FAIL_MESSAGE_002) != -1) {
                errorMsg = MyConstant.GC_0102_FAIL_MESSAGE_002;
                respondState = BankRespState.AMOUNTDIFFER.getKey();
            } else if (gasProtocalPackage.getPacketBody().indexOf(MyConstant.GC_0102_FAIL_MESSAGE_003) != -1) {
                errorMsg = MyConstant.GC_0102_FAIL_MESSAGE_002;
                respondState = BankRespState.OTHER_ERROR.getKey();
            }
            respError = true;
            break;
        case NOARREARS:// 没有欠费信息
            respError = true;
            errorMsg = MyConstant.GC_0101_FAIL_MESSAGE_001;
            respondState = BankRespState.NO_ARREARS.getKey();
            break;
        case FAIL_PAYMENT: // 待定????????
            errorMsg = MyConstant.GC_0102_FAIL_MESSAGE_002;
            respondState = BankRespState.OTHER_ERROR.getKey();
            respError = true;
            break;
        case FORMAL_ERROR: // 数据格式错误
            errorMsg = MyConstant.GC_0101_FAIL_MESSAGE_003;
            respondState = BankRespState.PACKET_ERROR.getKey();
            respError = true;
            break;
        default:
            break;
        }

        // 失败要做的事
        if (respError) {
            errorWrite(respondState, errorMsg, serverSessionKey, splitCount);
            return false;
        }

        // 01.协议类型：1： 有协议，0： 无协议
        bankPaymentResp.setProtocolType_s("0");
        bankPaymentResp.setProtocolType(ProtocolTxTUtil.strToCharArray(bankPaymentResp.getProtocolType_s()));
        bankPaymentResp.setCurrSavings(ProtocolTxTUtil.strToCharArray(bankPaymentResp.getCurrSavings_s()));

        // 02.用户性质:0： 居民 1：单位
        bankPaymentResp.setUserProperty_s("0");
        bankPaymentResp.setUserProperty(ProtocolTxTUtil.strToCharArray(bankPaymentResp.getUserProperty_s()));
        List<BankPaymentRespDetailEntity> list = new ArrayList<BankPaymentRespDetailEntity>();
        bankPaymentResp.setList(list);
        bankPacketHead.setDataLength_s(ProtocolTxTUtil.complementText(String.valueOf(bankPaymentResp.reply().length()), '0', 4, true));
        bankPacketHead.setDataLength(ProtocolTxTUtil.strToCharArray(bankPacketHead.getDataLength_s()));

        // step2:----------------------持久化----------------------------
        protocalPackage.setPacketHead(serverSessionKey.getPacketHead());
        protocalPackage.setPacketBody(bankPaymentResp.reply());
        protocalPackage.setBankCommand(serverSessionKey.getBankCommand());
        protocalPackage.setServerSessionKey(serverSessionKey.getServerSessionKey());
        mwFactoryService.getServerSession(serverSessionKey).write(protocalPackage);

        // step3:----------------------清空缓存----------------------------
        redisService.remove(MyConstant.REDIS_USER_ARREAR_PREFIX + serverSessionKey.getPacketBody().split(MyConstant.SPLIT1)[1]);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String transBody(BankProtocalPackage packetBody) {
        String[] vals = packetBody.getPacketBody().split(MyConstant.SPLIT1);
        StringBuffer sb = new StringBuffer();
        List<String> monthDetail = (List<String>) redisService.get(MyConstant.REDIS_USER_ARREAR_PREFIX + vals[1]);

        double yinSumMoney = 0L; // 总应缴费用
        double shiSumMoney = Double.valueOf(vals[2]); // 总实缴费用

        boolean isSingleMonth = true;
        if ("000000".equals(vals[6]))
            isSingleMonth = false;

        for (String item : monthDetail) {
            String[] temp = item.split(MyConstant.SPLIT1);
            if (isSingleMonth && vals[6].equals(temp[0])) {
                yinSumMoney = Double.valueOf(temp[1]);
                break;
            }
            yinSumMoney += Double.valueOf(temp[1]);
        }
        yinSumMoney = new BigDecimal(yinSumMoney).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        sb.append(yinSumMoney).append(MyConstant.SPLIT); // 总应缴费费用
        sb.append(shiSumMoney).append(MyConstant.SPLIT); // 总实缴费用
        double account = new BigDecimal(shiSumMoney - yinSumMoney).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); // 实缴费用 – 应缴费用
        sb.append(account).append(MyConstant.SPLIT); // 总账户余额

        for (int i = 0; i < monthDetail.size(); i++) {
            String[] temp = monthDetail.get(i).split(MyConstant.SPLIT1);
            if (isSingleMonth && !vals[6].equals(temp[0])) {
                continue;
            }

            sb.append(vals[1]).append(MyConstant.SPLIT); // 用户号
            sb.append(temp[0]).append(MyConstant.SPLIT); // 气费月份

            sb.append(temp[1]).append(MyConstant.SPLIT); // 应缴费用
            if (account > 0 && i == monthDetail.size() - 1) { // 实缴费用
                sb.append(new BigDecimal(Double.valueOf(temp[1]) + account).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()).append(MyConstant.SPLIT);
            } else
                sb.append(temp[1]).append(MyConstant.SPLIT);

            if (i == monthDetail.size() - 1) // 账户余额
                sb.append(account).append(MyConstant.SPLIT);
            else
                sb.append("0").append(MyConstant.SPLIT);

            sb.append(DateUtils.date2Str(DateUtils.yyyyMMdd)).append(MyConstant.SPLIT); // 缴费日期
            switch (packetBody.getPacketHead().getTransactionMode_s()) { // 缴费方式:1 柜面 2 批量代扣 3 自助 4 网上银行 5 电话银行
            case "01":
                sb.append("1");
                break;
            case "02":
                sb.append("2");
                break;
            case "03":
                sb.append("3");
                break;
            case "04":
                sb.append("5");
                break;
            case "05":
                sb.append("4");
                break;
            default:
                break;
            }
            sb.append(MyConstant.SPLIT);
            sb.append("2").append(MyConstant.SPLIT); // 缴费类别 1：现金 2：转帐

            String invoiceNo = "";
            if (vals.length == 9) // 判断是否有发票信息
                invoiceNo = vals[8];

            sb.append(invoiceNo).append(MyConstant.SPLIT).append(MyConstant.SPLIT2); // 发票号码
        }

        return sb.toString();
    }

    /**
     * 检查缓存是否失效或存在
     * 
     * @param userNo 用户号
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<String> cacheCheck(String userNo) {
        Object obj = redisService.get(MyConstant.REDIS_USER_ARREAR_PREFIX + userNo);

        return obj == null ? null : (List<String>) obj;
    }

    /**
     * 查询缴费月份是否正确
     * 
     * @param cache 缓存
     * @param month 缴费月份
     * @return
     */
    private boolean monthCheck(List<String> cache, String month) {
        if ("000000".equals(month))
            return true;

        for (String detail : cache)
            if (month.equals(detail.split(MyConstant.SPLIT1)[0]))
                return true;

        return false;
    }

    /**
     * 检查缴费金额是否正确
     * 
     * @param cache 缓存
     * @param userNo 用户号
     * @param money 缴费金额
     * @param month 缴费月份
     * @return
     * @throws Exception
     */
    private boolean moneyCheck(List<String> cache, String userNo, double money, String month) {
        double account = 0; // 缴费总额
        boolean success = false;

        if ("000000".equals(month)) { // 全额缴费
            for (String detail : cache)
                account += Double.valueOf(detail.split(MyConstant.SPLIT1)[1]);
            account = new BigDecimal(account).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (money - account >= 0)
                success = true;
        } else { // 单月缴费
            for (String detail : cache) {
                String[] temp = detail.split(MyConstant.SPLIT1);
                if (temp[0].equals(month))
                    if (money - Double.valueOf(temp[1]) >= 0)
                        success = true;
            }
        }

        return success;
    }
}
