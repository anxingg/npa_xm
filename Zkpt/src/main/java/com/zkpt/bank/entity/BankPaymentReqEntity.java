package com.zkpt.bank.entity;

import com.zkpt.util.ProtocolTxTUtil;

/**
 * 交易缴费,命令字:821
 * 
 * @author zhaoqi
 *
 */
public class BankPaymentReqEntity extends BankParentReqEntity implements java.io.Serializable{
    private static final long serialVersionUID = 4287464988304641437L;
    
    private char[] transactionCode; // 交易码
    private char[] userNo; // 用户编号
    private char[] paymentSum; // 缴费金额
    private char[] totalPayable; // 应交总额
    private char[] paymentTime; // 缴费时间
    private char[] operatorNo; // 操作工号
    private char[] month; // 缴费月份，缺省为000000，表示全额缴费；其它值为YYYYMM
    private char[] printInvoice; // 打印发票
    private char[] invoiceNo; // 发票号码

    private String transactionCode_s;
    private String userNo_s;
    private String paymentSum_s;
    private String totalPayable_s;
    private String paymentTime_s;
    private String operatorNo_s;
    private String month_s;
    private String printInvoice_s;
    private String invoiceNo_s;

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

    public char[] getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(char[] paymentSum) {
        this.paymentSum = paymentSum;
    }

    public char[] getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(char[] totalPayable) {
        this.totalPayable = totalPayable;
    }

    public char[] getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(char[] paymentTime) {
        this.paymentTime = paymentTime;
    }

    public char[] getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(char[] operatorNo) {
        this.operatorNo = operatorNo;
    }

    public char[] getMonth() {
        return month;
    }

    public void setMonth(char[] month) {
        this.month = month;
    }

    public char[] getPrintInvoice() {
        return printInvoice;
    }

    public void setPrintInvoice(char[] printInvoice) {
        this.printInvoice = printInvoice;
    }

    public char[] getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(char[] invoiceNo) {
        this.invoiceNo = invoiceNo;
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

    public String getPaymentSum_s() {
        return paymentSum_s;
    }

    public void setPaymentSum_s(String paymentSum_s) {
        this.paymentSum_s = paymentSum_s;
    }

    public String getTotalPayable_s() {
        return totalPayable_s;
    }

    public void setTotalPayable_s(String totalPayable_s) {
        this.totalPayable_s = totalPayable_s;
    }

    public String getPaymentTime_s() {
        return paymentTime_s;
    }

    public void setPaymentTime_s(String paymentTime_s) {
        this.paymentTime_s = paymentTime_s;
    }

    public String getOperatorNo_s() {
        return operatorNo_s;
    }

    public void setOperatorNo_s(String operatorNo_s) {
        this.operatorNo_s = operatorNo_s;
    }

    public String getMonth_s() {
        return month_s;
    }

    public void setMonth_s(String month_s) {
        this.month_s = month_s;
    }

    public String getPrintInvoice_s() {
        return printInvoice_s;
    }

    public void setPrintInvoice_s(String printInvoice_s) {
        this.printInvoice_s = printInvoice_s;
    }

    public String getInvoiceNo_s() {
        return invoiceNo_s;
    }

    public void setInvoiceNo_s(String invoiceNo_s) {
        this.invoiceNo_s = invoiceNo_s;
    }

    public static BankParentReqEntity packaging(String packageBody) {
        BankPaymentReqEntity entity = new BankPaymentReqEntity();
        String[] packageBodys = packageBody.split("\\|");
        entity.setTransactionCode_s(packageBodys[0]);
        entity.setUserNo_s(packageBodys[1]);
        entity.setPaymentSum_s(packageBodys[2]);
        entity.setTotalPayable_s(packageBodys[3]);
        entity.setPaymentTime_s(packageBodys[4]);
        entity.setOperatorNo_s(packageBodys[5]);
        entity.setMonth_s(packageBodys[6]);
        entity.setPrintInvoice_s(packageBodys[7]);

        String invoiceNo = "";
        if (packageBodys.length == 9) {
            invoiceNo = packageBodys[8];
        }
        entity.setInvoiceNo_s(invoiceNo);

        entity.setTransactionCode(ProtocolTxTUtil.strToCharArray(entity.getTransactionCode_s()));
        entity.setUserNo(ProtocolTxTUtil.strToCharArray(entity.getUserNo_s()));
        entity.setPaymentSum(ProtocolTxTUtil.strToCharArray(entity.getPaymentSum_s()));
        entity.setTotalPayable(ProtocolTxTUtil.strToCharArray(entity.getTotalPayable_s()));
        entity.setPaymentTime(ProtocolTxTUtil.strToCharArray(entity.getPaymentTime_s()));
        entity.setOperatorNo(ProtocolTxTUtil.strToCharArray(entity.getOperatorNo_s()));
        entity.setMonth(ProtocolTxTUtil.strToCharArray(entity.getMonth_s()));
        entity.setPrintInvoice(ProtocolTxTUtil.strToCharArray(entity.getPrintInvoice_s()));
        entity.setInvoiceNo(ProtocolTxTUtil.strToCharArray(entity.getInvoiceNo_s()));

        return entity;
    }
}
