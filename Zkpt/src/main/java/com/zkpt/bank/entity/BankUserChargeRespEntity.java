package com.zkpt.bank.entity;

import com.zkpt.middleware.entity.CombinationIndex;
import com.zkpt.middleware.entity.ReplyParent;
import com.zkpt.util.TrickUitl;

/**
 * 用户冲帐响应包
 * 
 * @author zhaoqi
 *
 */
public class BankUserChargeRespEntity implements ReplyParent, java.io.Serializable {
    private static final long serialVersionUID = 9098256885998532924L;

    private char[] transactionCode; // 交易码
    private char[] responseCode; // 响应码
    private char[] userNo; // 用户编号
    private char[] bankSerialNumber; // 银行流水号
    private char[] currPayment; // 本次缴费

    @CombinationIndex(index = 1)
    private String transactionCode_s;
    @CombinationIndex(index = 2)
    private String responseCode_s;
    @CombinationIndex(index = 3)
    private String userNo_s;
    @CombinationIndex(index = 4)
    private String bankSerialNumber_s;
    @CombinationIndex(index = 5)
    private Double currPayment_s;

    private BankUserChargeRespEntity self; // 自己的对象指针

    public char[] getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(char[] transactionCode) {
        this.transactionCode = transactionCode;
    }

    public char[] getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(char[] responseCode) {
        this.responseCode = responseCode;
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

    public char[] getCurrPayment() {
        return currPayment;
    }

    public void setCurrPayment(char[] currPayment) {
        this.currPayment = currPayment;
    }

    public String getTransactionCode_s() {
        return transactionCode_s;
    }

    public void setTransactionCode_s(String transactionCode_s) {
        this.transactionCode_s = transactionCode_s;
    }

    public String getResponseCode_s() {
        return responseCode_s;
    }

    public void setResponseCode_s(String responseCode_s) {
        this.responseCode_s = responseCode_s;
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

    public Double getCurrPayment_s() {
        return currPayment_s;
    }

    public void setCurrPayment_s(Double currPayment_s) {
        this.currPayment_s = currPayment_s;
    }

    public BankUserChargeRespEntity getSelf() {
        return self;
    }

    public void setSelf(BankUserChargeRespEntity self) {
        this.self = self;
    }

    @Override
    public String reply() {
        return TrickUitl.reply_resp_combination(self);
    }
}
