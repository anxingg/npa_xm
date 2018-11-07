package com.zkpt.middleware.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.bank.service.IBankGeneralLedgerService;
import com.zkpt.bank.service.IBankPaymentService;
import com.zkpt.bank.service.IBankQueryArrearsService;
import com.zkpt.bank.service.IBankUserChargeService;
import com.zkpt.gas.entity.GasProtocalPackage;
import com.zkpt.middleware.service.IMwTransportService;
import com.zkpt.util.ProtocolTxTUtil;

@Service("wmTransportService")
public class MwTransportServiceImpl implements IMwTransportService {
    private final static Logger logger = LoggerFactory.getLogger(MwTransportServiceImpl.class);

    @Autowired
    private Environment env;
    @Autowired
    private IBankQueryArrearsService bankQueryArrearsService;
    @Autowired
    private IBankPaymentService bankPaymentService;
    @Autowired
    private IBankUserChargeService bankUserChargeService;
    @Autowired
    private IBankGeneralLedgerService bankGeneralLedgerService;

    @Override
    public boolean trans_in(BankProtocalPackage bankProtocalPackage) {
        try {
            // 更改银行编码
            String convertBankCode = env.getProperty("bank.code");
            bankProtocalPackage.getPacketHead().setPaymentCode_s(convertBankCode);
            bankProtocalPackage.getPacketHead().setPaymentCode(ProtocolTxTUtil.strToCharArray(convertBankCode));

            switch (bankProtocalPackage.getBankCommand()) {
            case COST_ARREARAGE:
                bankQueryArrearsService.request(bankProtocalPackage);
                break;
            case PAYMENT:
                bankPaymentService.request(bankProtocalPackage);
                break;
            case USER_CHARGE:
                bankUserChargeService.request(bankProtocalPackage);
                break;
            case GENERAL_LEDGER:
                bankGeneralLedgerService.request(bankProtocalPackage);
                break;
            default:
                break;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean trans_out(GasProtocalPackage gasProtocalPackage, BankProtocalPackage serverSessionKey) throws IOException {
        try {
            switch (gasProtocalPackage.getGasCommand()) {
            case YHQFQK_COMM:
                bankQueryArrearsService.response(gasProtocalPackage, serverSessionKey);
                break;
            case QFJN_COMM:
                bankPaymentService.response(gasProtocalPackage, serverSessionKey);
                break;
            case QXJF_COMM:
                bankUserChargeService.response(gasProtocalPackage, serverSessionKey);
                break;
            case DZRZ_COMM:
                bankGeneralLedgerService.response(gasProtocalPackage, serverSessionKey);
                break;
            default:
                break;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
}
