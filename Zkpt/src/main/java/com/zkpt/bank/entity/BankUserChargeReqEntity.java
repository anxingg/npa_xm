package com.zkpt.bank.entity;

import com.zkpt.util.ProtocolTxTUtil;

/**
 * 用户冲帐（取消收费）只能取消当日收费交易,命令字:850
 * 
 * @author zhaoqi
 *
 */
public class BankUserChargeReqEntity extends BankParentReqEntity implements java.io.Serializable {
    private static final long serialVersionUID = -8141440274585058840L;
    private char[] transactionCode; // 交易码
    private char[] userNo; // 用户编号
    private char[] bankSerialNumber; // 银行流水号

    private String transactionCode_s;
    private String userNo_s;
    private String bankSerialNumber_s;

    public char[] getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(char[] transactionCode) {
        this.transactionCode = transactionCode;
    }

    public char[] getUserNo() {
        return userNo;
    }

    public void setUserNo(char[] userNo) {
        this.userNo = userNo;
    }

    public char[] getBankSerialNumber() {
        return bankSerialNumber;
    }

    public void setBankSerialNumber(char[] bankSerialNumber) {
        this.bankSerialNumber = bankSerialNumber;
    }

    public String getTransactionCode_s() {
        return transactionCode_s;
    }

    public void setTransactionCode_s(String transactionCode_s) {
        this.transactionCode_s = transactionCode_s;
    }

    public String getUserNo_s() {
        return userNo_s;
    }

    public void setUserNo_s(String userNo_s) {
        this.userNo_s = userNo_s;
    }

    public String getBankSerialNumber_s() {
        return bankSerialNumber_s;
    }

    public void setBankSerialNumber_s(String bankSerialNumber_s) {
        this.bankSerialNumber_s = bankSerialNumber_s;
    }

    public static BankParentReqEntity packaging(String packageBody) {
        BankUserChargeReqEntity entity = new BankUserChargeReqEntity();
        String[] packageBodys = packageBody.split("\\|");
        entity.setTransactionCode_s(packageBodys[0]);
        entity.setUserNo_s(packageBodys[1]);
        entity.setBankSerialNumber_s(packageBodys[2]);
        entity.setTransactionCode(ProtocolTxTUtil.strToCharArray(entity.getTransactionCode_s()));
        entity.setUserNo(ProtocolTxTUtil.strToCharArray(entity.getUserNo_s()));
        entity.setBankSerialNumber(ProtocolTxTUtil.strToCharArray(entity.getBankSerialNumber_s()));
        return entity;
    }

}
