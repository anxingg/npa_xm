package com.zkpt.bank.entity;

/**
 * 包头
 * 
 * @author 孙培
 *
 */
public class BankPacketHeadEntity {
    private char[] fixedNumber; // 包头：char 32字节固定格式，第1－2 填“01”即可
    private char[] paymentCode; // 缴费点代码，第3－6个字节：缴费点代码，例如 0009 :地方银行
    private char[] paymentPointPassword; // 缴费点密码，第7－11个字节：为缴费点密码。(目前填写为空格)
    private char[] spare; // 备用，第12－12个字节：备用 。（目前填写空格）
    private char[] transactionMode; // 交易方式 ，第13－14：交易方式：银行柜台-01；批量代扣-02；自动终端-03；电话银行-04；网上银行-05；手机银行-06
    private char[] transactionFlow; // 交易流水号，第15－28个字节为：交易流水靠左边右补充空格
    private char[] dataLength; // 包体长度字节数，第29－32 数据包长度字节，为字符格式，如数据包长123字节，表示为“0123”。数据包长度不包含包头和包长度本身
    private char[] baotouEnd; // 包头结束符 ，第33字节为“|”分隔符

    private String fixedNumber_s;
    private String paymentCode_s;
    private String paymentPointPassword_s;
    private String spare_s;
    private String transactionMode_s;
    private String transactionFlow_s;
    private String dataLength_s;
    private String baotouEnd_s;

    public BankPacketHeadEntity() {}

    public char[] getFixedNumber() {
        return fixedNumber;
    }

    public void setFixedNumber(char[] fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    public char[] getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(char[] paymentCode) {
        this.paymentCode = paymentCode;
    }

    public char[] getPaymentPointPassword() {
        return paymentPointPassword;
    }

    public void setPaymentPointPassword(char[] paymentPointPassword) {
        this.paymentPointPassword = paymentPointPassword;
    }

    public char[] getSpare() {
        return spare;
    }

    public void setSpare(char[] spare) {
        this.spare = spare;
    }

    public char[] getDataLength() {
        return dataLength;
    }

    public void setDataLength(char[] dataLength) {
        this.dataLength = dataLength;
    }

    public char[] getBaotouEnd() {
        return baotouEnd;
    }

    public void setBaotouEnd(char[] baotouEnd) {
        this.baotouEnd = baotouEnd;
    }

    public String getFixedNumber_s() {
        return fixedNumber_s;
    }

    public void setFixedNumber_s(String fixedNumber_s) {
        this.fixedNumber_s = fixedNumber_s;
    }

    public String getPaymentCode_s() {
        return paymentCode_s;
    }

    public void setPaymentCode_s(String paymentCode_s) {
        this.paymentCode_s = paymentCode_s;
    }

    public String getPaymentPointPassword_s() {
        return paymentPointPassword_s;
    }

    public void setPaymentPointPassword_s(String paymentPointPassword_s) {
        this.paymentPointPassword_s = paymentPointPassword_s;
    }

    public String getSpare_s() {
        return spare_s;
    }

    public void setSpare_s(String spare_s) {
        this.spare_s = spare_s;
    }

    public String getDataLength_s() {
        return dataLength_s;
    }

    public void setDataLength_s(String dataLength_s) {
        this.dataLength_s = dataLength_s;
    }

    public String getBaotouEnd_s() {
        return baotouEnd_s;
    }

    public void setBaotouEnd_s(String baotouEnd_s) {
        this.baotouEnd_s = baotouEnd_s;
    }

    public char[] getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(char[] transactionMode) {
        this.transactionMode = transactionMode;
    }

    public char[] getTransactionFlow() {
        return transactionFlow;
    }

    public void setTransactionFlow(char[] transactionFlow) {
        this.transactionFlow = transactionFlow;
    }

    public String getTransactionMode_s() {
        return transactionMode_s;
    }

    public void setTransactionMode_s(String transactionMode_s) {
        this.transactionMode_s = transactionMode_s;
    }

    public String getTransactionFlow_s() {
        return transactionFlow_s;
    }

    public void setTransactionFlow_s(String transactionFlow_s) {
        this.transactionFlow_s = transactionFlow_s;
    }

}
