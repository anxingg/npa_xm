package com.zkpt.bank.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.bank.service.IBankService;
import com.zkpt.gas.entity.GasCommand;
import com.zkpt.gas.entity.GasProtocalPackage;
import com.zkpt.middleware.entity.MyConstant;
import com.zkpt.middleware.service.IMwFactoryService;
import com.zkpt.util.DateUtils;
import com.zkpt.util.ProtocolTxTUtil;

@Service("bankService")
@Transactional
public class BankServiceImpl implements IBankService {
    private final static Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    protected IMwFactoryService mwFactoryService;

    @Override
    public boolean request(BankProtocalPackage bankProtocalPackage) throws Exception {
        return true;
    }

    @Override
    public boolean response(GasProtocalPackage gasProtocalPackage, BankProtocalPackage serverSessionKey) throws Exception {
        return true;
    }

    @Override
    public boolean loged() throws Exception {
        return true;
    }

    @Override
    public boolean persistenced() throws Exception {
        return true;
    }

    @Override
    public GasProtocalPackage protocalTransToGas(BankProtocalPackage bankProtocalPackage, String body) {
        GasProtocalPackage gasProtocalPackage = new GasProtocalPackage();
        gasProtocalPackage.setPacketBody(body);

        switch (bankProtocalPackage.getBankCommand()) {
        case COST_ARREARAGE:
            gasProtocalPackage.setGasCommand(GasCommand.YHQFQK_COMM);
            break;
        case PAYMENT:
            gasProtocalPackage.setGasCommand(GasCommand.QFJN_COMM);
            break;
        case USER_CHARGE:
            gasProtocalPackage.setGasCommand(GasCommand.QXJF_COMM);
            break;
        case GENERAL_LEDGER:
            gasProtocalPackage.setGasCommand(GasCommand.JFLS_COMM);
            break;
        case ESTABLISH_PROTOCOLT:
            break;
        case DELETE_PROTOCOL:
            break;
        case QUERY_PROTOCOL:
            break;
        case QUERY_CARD_PROTOCOL:
            break;
        case QUERY_NUMBER:
            break;
        case REQUEST_DEDUCTION:
            break;
        case RETURN_DEDUCTION:
            break;
        default:
            break;
        }

        gasProtocalPackage.getPacketHead().setRequestId_s(gasProtocalPackage.getGasCommand().getKey());
        // 如果是自助设备发起，则 BankNo 填写 000,BankDeviceNo 填写自助设备编号，BankBizSn则为自助设备自身维护的业务流水号。这点还未写
        gasProtocalPackage.getPacketHead().setBankNo_s(bankProtocalPackage.getPacketHead().getPaymentCode_s().substring(1));
        gasProtocalPackage.getPacketHead().setBankDeviceNo_s(ProtocolTxTUtil.complementText(bankProtocalPackage.getPacketHead().getTransactionMode_s(), '0', 10, true));
        gasProtocalPackage.getPacketHead().setBankBizSn_s(ProtocolTxTUtil.complementText(bankProtocalPackage.getPacketHead().getTransactionFlow_s().trim(), '0', 10, true));
        gasProtocalPackage.getPacketHead().setRespondState_s("0000");
        gasProtocalPackage.getPacketHead().setIsNextPacket_s("0");
        gasProtocalPackage.getPacketHead().setDataLength_s(ProtocolTxTUtil.complementText(String.valueOf(body.length()), '0', 5, true));
        gasProtocalPackage.getPacketHead().setTimeStamp_s(DateUtils.date2Str(DateUtils.yyyymmddhhmmss));

        gasProtocalPackage.getPacketHead().setRequestId(ProtocolTxTUtil.strToCharArray(gasProtocalPackage.getPacketHead().getRequestId_s()));
        gasProtocalPackage.getPacketHead().setBankNo(ProtocolTxTUtil.strToCharArray(gasProtocalPackage.getPacketHead().getBankNo_s()));
        gasProtocalPackage.getPacketHead().setBankDeviceNo(ProtocolTxTUtil.strToCharArray(gasProtocalPackage.getPacketHead().getBankDeviceNo_s()));
        gasProtocalPackage.getPacketHead().setBankBizSn(ProtocolTxTUtil.strToCharArray(gasProtocalPackage.getPacketHead().getBankBizSn_s()));
        gasProtocalPackage.getPacketHead().setRespondState(ProtocolTxTUtil.strToCharArray(gasProtocalPackage.getPacketHead().getRespondState_s()));
        gasProtocalPackage.getPacketHead().setIsNextPacket(ProtocolTxTUtil.strToCharArray(gasProtocalPackage.getPacketHead().getIsNextPacket_s()));
        gasProtocalPackage.getPacketHead().setDataLength(ProtocolTxTUtil.strToCharArray(gasProtocalPackage.getPacketHead().getDataLength_s()));
        gasProtocalPackage.getPacketHead().setTimeStamp(ProtocolTxTUtil.strToCharArray(gasProtocalPackage.getPacketHead().getTimeStamp_s()));

        return gasProtocalPackage;
    }

    @Override
    public String transBody(BankProtocalPackage packetBody) {
        return null;
    }

    public void errorWrite(String respondState, String errorMsg, BankProtocalPackage bankProtocalPackage, int splitCount) {
        StringBuffer sb = new StringBuffer();

        bankProtocalPackage.setPacketBody("");
        sb.append(bankProtocalPackage.getBankCommand().getKey() + MyConstant.SPLIT);
        sb.append(respondState).append(MyConstant.SPLIT);
        for (int i = 0; i < splitCount; i++) {
            sb.append(MyConstant.SPLIT);
        }

        int newBodyLength = sb.toString().length();
        bankProtocalPackage.getPacketHead().setDataLength_s(String.valueOf(newBodyLength));
        bankProtocalPackage.getPacketHead().setDataLength(ProtocolTxTUtil.strToCharArray(bankProtocalPackage.getPacketHead().getDataLength_s()));
        bankProtocalPackage.setPacketBody(sb.toString());
        logger.info(errorMsg);
        mwFactoryService.getServerSession(bankProtocalPackage).write(bankProtocalPackage);
    }
}
