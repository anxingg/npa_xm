package com.zkpt.bank.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.bank.entity.BankCostArrearageReqEntity;
import com.zkpt.bank.entity.BankCostArrearageRespDetailEntity;
import com.zkpt.bank.entity.BankCostArrearageRespEntity;
import com.zkpt.bank.entity.BankPacketHeadEntity;
import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.bank.entity.BankRespState;
import com.zkpt.bank.service.IBankQueryArrearsService;
import com.zkpt.data.entity.BankDevice;
import com.zkpt.data.entity.BankDeviceBehavior;
import com.zkpt.data.entity.GasUser;
import com.zkpt.data.entity.GasUserBehavior;
import com.zkpt.data.entity.GasUserCost;
import com.zkpt.data.entity.Operation;
import com.zkpt.data.service.GasUserServiceI;
import com.zkpt.gas.entity.GasCostArrearageRespDetailEntity;
import com.zkpt.gas.entity.GasProtocalPackage;
import com.zkpt.gas.entity.GasRespState;
import com.zkpt.middleware.entity.MyConstant;
import com.zkpt.redis.service.IRedisService;
import com.zkpt.util.ProtocolTxTUtil;


@Service("bankQueryArrearsService")
@Transactional
public class BankQueryArrearsServiceImpl extends BankServiceImpl implements IBankQueryArrearsService {
    private final static Logger logger = LoggerFactory.getLogger(BankQueryArrearsServiceImpl.class);
    private final static int splitCount = 24;

    @Autowired
    private IRedisService redisService;
    @Autowired
    private GasUserServiceI gasUserService;

    @Override
    public boolean request(BankProtocalPackage bankProtocalPackage) throws Exception {
        GasProtocalPackage gasProtocalPackage = protocalTransToGas(bankProtocalPackage, transBody(bankProtocalPackage));
        bankProtocalPackage.setPacketBodyEntity(BankCostArrearageReqEntity.packaging(bankProtocalPackage.getPacketBody()));
        IoSession ioSession = mwFactoryService.createMWClient();

        if (ioSession == null) {
            errorWrite(BankRespState.OTHER_ERROR.getKey(), MyConstant.ERROR_PAY_002, bankProtocalPackage, splitCount);
            return false;
        }

        ioSession.setAttribute("serverSessionKey", bankProtocalPackage);
        ioSession.write(gasProtocalPackage);

        return true;
    }

    @Override
    public boolean response(GasProtocalPackage gasProtocalPackage, BankProtocalPackage serverSessionKey) throws Exception {
        BankCostArrearageRespEntity bankCostArrearageResp = new BankCostArrearageRespEntity(); // 返回银行客户端的响应包
        BankProtocalPackage protocalPackage = new BankProtocalPackage(); // 实际返回银行的协议包(编码器用)
        BankPacketHeadEntity bankPacketHead = serverSessionKey.getPacketHead();

        bankCostArrearageResp.setSelf(bankCostArrearageResp);
        boolean respError = false;
        String errorMsg = "", respondState = "";

        // step1:----------------------组装response响应包----------------------------
        // 01.交易码
        bankCostArrearageResp.setTransactionCode_s(((BankCostArrearageReqEntity) serverSessionKey.getPacketBodyEntity()).getTransactionCode_s());
        bankCostArrearageResp.setTransactionCode(ProtocolTxTUtil.strToCharArray(bankCostArrearageResp.getTransactionCode_s()));

        // 02.响应码
        switch (GasRespState.getEnumByKey(gasProtocalPackage.getPacketHead().getRespondState_s())) {
        case SUCESS:
            bankCostArrearageResp.setResponseCode_s(BankRespState.TRADE_SUCESS.getKey()); // 成功的响应码
            bankCostArrearageResp.setResponseCode(ProtocolTxTUtil.strToCharArray(BankRespState.TRADE_SUCESS.getKey()));
            break;
        case FAIL_DETAIL:
            respError = true;
            break;
        case NOARREARS:
            if (gasProtocalPackage.getPacketBody().indexOf(MyConstant.GC_0101_FAIL_MESSAGE_002) != -1) { // 用户不存在
                errorMsg = MyConstant.GC_0101_FAIL_MESSAGE_002;
                respondState = BankRespState.USER_NOEXIST.getKey();
            }
            respError = true;
            break;
        case FAIL:
            if (gasProtocalPackage.getPacketBody().indexOf(MyConstant.GC_0101_FAIL_MESSAGE_001) != -1) { // 用户无欠费
                errorMsg = MyConstant.GC_0101_FAIL_MESSAGE_001;
                respondState = BankRespState.NO_ARREARS.getKey();
            }
            respError = true;
            break;
        case MOREARREARS:
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

        int idx = 0;
        String temp = gasProtocalPackage.getPacketBody();
        // 01.欠费总额
        idx = temp.indexOf(MyConstant.SPLIT);
        bankCostArrearageResp.setTotalArrears_s(Double.parseDouble(temp.substring(0, idx)));
        bankCostArrearageResp.setTotalArrears(ProtocolTxTUtil.strToCharArray(temp.substring(0, idx)));
        temp = temp.substring(++idx);

        // 02.欠费月数
        idx = temp.indexOf(MyConstant.SPLIT);
        int month = Integer.parseInt(temp.substring(0, idx));
        temp = temp.substring(++idx);

        // 03.协议类型：1： 有协议，0： 无协议
        bankCostArrearageResp.setProtocolType_s("0");
        bankCostArrearageResp.setProtocolType(ProtocolTxTUtil.strToCharArray(bankCostArrearageResp.getProtocolType_s()));

        // 04.用户性质:0： 居民 1：单位
        bankCostArrearageResp.setUserProperty_s("0");
        bankCostArrearageResp.setUserProperty(ProtocolTxTUtil.strToCharArray(bankCostArrearageResp.getUserProperty_s()));

        // 05. 明细次数
        bankCostArrearageResp.setDetailTimes_s(Integer.valueOf(month));
        bankCostArrearageResp.setDetailTimes(ProtocolTxTUtil.strToCharArray(month + ""));

        double consumption = 0d, penalty = 0d, arrearsTotal = 0d, lastRead = 0d, reading = 0d;
        int startMonth = 0, endMonth = 0;
        String userName = "", userNo = "";

        String[] monthDetail = temp.split(MyConstant.SPLIT3);

        List<BankCostArrearageRespDetailEntity> list = new ArrayList<BankCostArrearageRespDetailEntity>();
        List<GasCostArrearageRespDetailEntity> arrearList = new ArrayList<GasCostArrearageRespDetailEntity>();

        for (int i = 0; i < monthDetail.length; i++) {
            BankCostArrearageRespDetailEntity bankCostArrearageRespDetailEntity = new BankCostArrearageRespDetailEntity();
            GasCostArrearageRespDetailEntity basCostArrearageRespDetailEntity = new GasCostArrearageRespDetailEntity();
            String[] vals = monthDetail[i].split(MyConstant.SPLIT1);
            userNo = vals[0];
            userName = vals[1];
            // 抄表时间
            bankCostArrearageRespDetailEntity.setMeterReadingTime_s("");
            bankCostArrearageRespDetailEntity.setMeterReadingTime(ProtocolTxTUtil.strToCharArray(""));
            // 起码
            bankCostArrearageRespDetailEntity.setStartCode_s(vals[3]);
            bankCostArrearageRespDetailEntity.setStartCode(ProtocolTxTUtil.strToCharArray(vals[3]));
            // 止码
            bankCostArrearageRespDetailEntity.setStopCode_s(vals[4]);
            bankCostArrearageRespDetailEntity.setStopCode(ProtocolTxTUtil.strToCharArray(vals[4]));
            // 实用吨数
            bankCostArrearageRespDetailEntity.setPracticalTonnage_s(Double.parseDouble(vals[5]));
            bankCostArrearageRespDetailEntity.setPracticalTonnage(ProtocolTxTUtil.strToCharArray(vals[5]));
            consumption += Double.parseDouble(vals[5]);
            // 违约金
            bankCostArrearageRespDetailEntity.setPenalty_s(Double.parseDouble(vals[8]));
            bankCostArrearageRespDetailEntity.setPenalty(ProtocolTxTUtil.strToCharArray(vals[8]));
            penalty += Double.parseDouble(vals[8]);
            // 本月欠费总额
            bankCostArrearageRespDetailEntity.setCurrentMonthArrearsTotal_s(Double.parseDouble(vals[9]));
            bankCostArrearageRespDetailEntity.setCurrentMonthArrearsTotal(ProtocolTxTUtil.strToCharArray(vals[9]));
            arrearsTotal += Double.parseDouble(vals[9]);

            // 缴费标志
            bankCostArrearageRespDetailEntity.setPaymentSign_s("0");
            bankCostArrearageRespDetailEntity.setPaymentSign(ProtocolTxTUtil.strToCharArray(bankCostArrearageRespDetailEntity.getPaymentSign_s()));
            list.add(bankCostArrearageRespDetailEntity);

            basCostArrearageRespDetailEntity.setPayAbleAirCost_s(vals[9]);
            basCostArrearageRespDetailEntity.setMonth_s(vals[2]);
            arrearList.add(basCostArrearageRespDetailEntity);

            // 最近的一个月
            if (i == 0) {
                startMonth = Integer.parseInt(vals[2]);
                lastRead = Integer.parseInt(vals[3]);
            }

            // 最后一个月
            if (month == i + 1) {
                endMonth = Integer.parseInt(vals[2]);
                reading = Integer.parseInt(vals[4]);
            }
        }

        // 06.用户编号
        bankCostArrearageResp.setUserNo_s(userNo);
        bankCostArrearageResp.setUserNo(ProtocolTxTUtil.strToCharArray(userNo));

        // 07.用户名称
        bankCostArrearageResp.setUserName_s(userName);
        bankCostArrearageResp.setUserName(ProtocolTxTUtil.strToCharArray(userName));

        // 08.用气量
        bankCostArrearageResp.setGasConsumption_s(Double.valueOf(consumption));
        bankCostArrearageResp.setGasConsumption(ProtocolTxTUtil.strToCharArray(String.valueOf(consumption)));

        // 09. 气费
        bankCostArrearageResp.setGasFee_s(Double.valueOf(arrearsTotal));
        bankCostArrearageResp.setGasFee(ProtocolTxTUtil.strToCharArray(String.valueOf(arrearsTotal)));

        // 10.违约金
        bankCostArrearageResp.setPenalty_s(Double.valueOf(penalty));
        bankCostArrearageResp.setPenalty(ProtocolTxTUtil.strToCharArray(String.valueOf(penalty)));

        // 11.开始月份
        bankCostArrearageResp.setStartMonth_s(String.valueOf(startMonth));
        bankCostArrearageResp.setStartMonth(ProtocolTxTUtil.strToCharArray(String.valueOf(startMonth)));

        // 12.终止月份
        bankCostArrearageResp.setEndMonth_s(String.valueOf(endMonth));
        bankCostArrearageResp.setEndMonth(ProtocolTxTUtil.strToCharArray(String.valueOf(endMonth)));

        // 13.上次读数
        bankCostArrearageResp.setLastRead_s(Double.valueOf(lastRead));
        bankCostArrearageResp.setLastRead(ProtocolTxTUtil.strToCharArray(String.valueOf(lastRead)));

        // 14.本次读数
        bankCostArrearageResp.setReading_s(Double.valueOf(reading));
        bankCostArrearageResp.setReading(ProtocolTxTUtil.strToCharArray(String.valueOf(reading)));

        // 15. 应交金额:欠费总额-现有节余
        bankCostArrearageResp.setPayableAmount_s(Double.valueOf(arrearsTotal));
        bankCostArrearageResp.setPayableAmount(ProtocolTxTUtil.strToCharArray(String.valueOf(arrearsTotal)));

        bankCostArrearageResp.setList(list);

        String reply = bankCostArrearageResp.reply();
        bankPacketHead.setDataLength_s(ProtocolTxTUtil.complementText(String.valueOf(reply.length()), '0', 4, true));
        bankPacketHead.setDataLength(ProtocolTxTUtil.strToCharArray(bankPacketHead.getDataLength_s()));

        // step2:----------------------协议写入----------------------------
        protocalPackage.setPacketHead(serverSessionKey.getPacketHead());
        protocalPackage.setPacketBody(reply);
        protocalPackage.setBankCommand(serverSessionKey.getBankCommand());
        protocalPackage.setServerSessionKey(serverSessionKey.getServerSessionKey());
        mwFactoryService.getServerSession(serverSessionKey).write(protocalPackage);
        // step3:----------------------持久化----------------------------
        GasUser gasUser = new GasUser();
        gasUser.setUserNo(userNo);
        gasUser.setUserName(userName);
        gasUser.setCreateBy("system");
        gasUser.setCreateDate(new Date());
        
        BankDevice bankDevice = new BankDevice();
        bankDevice.setBankNo(((BankPacketHeadEntity) serverSessionKey.getPacketHead()).getPaymentCode_s());
        bankDevice.setCreateBy("system");
        bankDevice.setCreateDate(new Date());
        
        BankDeviceBehavior bankDeviceBehavior = new BankDeviceBehavior();
        bankDeviceBehavior.setCreateBy("system");
        bankDeviceBehavior.setCreateDate(new Date());
        
        GasUserBehavior gasUserBehavior = new GasUserBehavior();
        gasUserBehavior.setUserNo(userNo);
        gasUserBehavior.setCreateBy("system");
        gasUserBehavior.setCreateDate(new Date());
        
        GasUserCost gasUserCost = new GasUserCost();
        gasUserCost.setUserName(userName);
        gasUserCost.setUserNo(userNo);
        gasUserCost.setPrevVal(new BigDecimal(bankCostArrearageResp.getLastRead_s()));
        gasUserCost.setCurrVal(new BigDecimal(bankCostArrearageResp.getReading_s()));
        
        Operation operation = new Operation();
        operation.setBankIp(serverSessionKey.getClientIp());
        operation.setBankPort(serverSessionKey.getClientPort());
        operation.setBankSend(serverSessionKey.getPacketHead_s()+serverSessionKey.getPacketBody());
        operation.setBankSendTime(serverSessionKey.getSentTime());
        operation.setGasEcho(gasProtocalPackage.getPacketHead_s()+gasProtocalPackage.getPacketBody());
        operation.setGasEchoTime(gasProtocalPackage.getEchoTime());
        operation.setBankCommand(serverSessionKey.getBankCommand().getKey());
        operation.setGasCommand(gasProtocalPackage.getGasCommand().getKey());
        operation.setState("S");
        operation.setCreateDate(new Date());
        gasUserService.isOperation(gasUser, bankDevice, bankDeviceBehavior, gasUserBehavior, gasUserCost, operation);

        // step4:----------------------缓存化----------------------------
        cacheArrears(userNo, arrearList);
        return true;
    }

    @Override
    public String transBody(BankProtocalPackage packetBody) {
        return packetBody.getPacketBody().split(MyConstant.SPLIT1)[1] + MyConstant.SPLIT;
    }

    /**
     * 缓存redis
     * 
     * @param userNo
     * @param gasCostArrearageRespDetailList
     * @return
     */
    private boolean cacheArrears(String userNo, List<GasCostArrearageRespDetailEntity> gasCostArrearageRespDetailList) {
        List<String> val = new ArrayList<String>();

        for (GasCostArrearageRespDetailEntity item : gasCostArrearageRespDetailList) {
            StringBuffer sb = new StringBuffer();
            val.add(sb.append(item.getMonth_s()).append(MyConstant.SPLIT).append(item.getPayAbleAirCost_s()).toString());
        }

        redisService.set(MyConstant.REDIS_USER_ARREAR_PREFIX + userNo, val, MyConstant.REDIS_DEFAULT_TIMETOLIVE);
        return true;
    }
}
