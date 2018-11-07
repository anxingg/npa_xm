package com.zkpt.bank.entity;

import com.zkpt.middleware.entity.CombinationIndex;

/**
 * 欠费查询响应包Detial明细
 * 
 * @author 孙培
 *
 */
public class BankCostArrearageRespDetailEntity implements java.io.Serializable {
    private static final long serialVersionUID = 6418227845327243893L;
    private char[] meterReadingTime; // 抄表时间
    private char[] startCode; // 起码
    private char[] stopCode; // 止码
    private char[] practicalTonnage; // 实用吨数
    private char[] penalty; // 违约金
    private char[] currentMonthArrearsTotal; // 本月欠费总额
    private char[] paymentSign; // 缴费标志

    @CombinationIndex(index = 1)
    private String meterReadingTime_s;
    @CombinationIndex(index = 2)
    private String startCode_s;
    @CombinationIndex(index = 3)
    private String stopCode_s;
    @CombinationIndex(index = 4)
    private Double practicalTonnage_s;
    @CombinationIndex(index = 5)
    private Double penalty_s;
    @CombinationIndex(index = 6)
    private Double currentMonthArrearsTotal_s;
    @CombinationIndex(index = 7)
    private String paymentSign_s;

    public char[] getMeterReadingTime() {
        return meterReadingTime;
    }

    public void setMeterReadingTime(char[] meterReadingTime) {
        this.meterReadingTime = meterReadingTime;
    }

    public char[] getStartCode() {
        return startCode;
    }

    public void setStartCode(char[] startCode) {
        this.startCode = startCode;
    }

    public char[] getStopCode() {
        return stopCode;
    }

    public void setStopCode(char[] stopCode) {
        this.stopCode = stopCode;
    }

    public char[] getPracticalTonnage() {
        return practicalTonnage;
    }

    public void setPracticalTonnage(char[] practicalTonnage) {
        this.practicalTonnage = practicalTonnage;
    }

    public char[] getPenalty() {
        return penalty;
    }

    public void setPenalty(char[] penalty) {
        this.penalty = penalty;
    }

    public char[] getCurrentMonthArrearsTotal() {
        return currentMonthArrearsTotal;
    }

    public void setCurrentMonthArrearsTotal(char[] currentMonthArrearsTotal) {
        this.currentMonthArrearsTotal = currentMonthArrearsTotal;
    }

    public char[] getPaymentSign() {
        return paymentSign;
    }

    public void setPaymentSign(char[] paymentSign) {
        this.paymentSign = paymentSign;
    }

    public String getMeterReadingTime_s() {
        return meterReadingTime_s;
    }

    public void setMeterReadingTime_s(String meterReadingTime_s) {
        this.meterReadingTime_s = meterReadingTime_s;
    }

    public String getStartCode_s() {
        return startCode_s;
    }

    public void setStartCode_s(String startCode_s) {
        this.startCode_s = startCode_s;
    }

    public String getStopCode_s() {
        return stopCode_s;
    }

    public void setStopCode_s(String stopCode_s) {
        this.stopCode_s = stopCode_s;
    }

    public Double getPracticalTonnage_s() {
        return practicalTonnage_s;
    }

    public void setPracticalTonnage_s(Double practicalTonnage_s) {
        this.practicalTonnage_s = practicalTonnage_s;
    }

    public Double getPenalty_s() {
        return penalty_s;
    }

    public void setPenalty_s(Double penalty_s) {
        this.penalty_s = penalty_s;
    }

    public Double getCurrentMonthArrearsTotal_s() {
        return currentMonthArrearsTotal_s;
    }

    public void setCurrentMonthArrearsTotal_s(Double currentMonthArrearsTotal_s) {
        this.currentMonthArrearsTotal_s = currentMonthArrearsTotal_s;
    }

    public String getPaymentSign_s() {
        return paymentSign_s;
    }

    public void setPaymentSign_s(String paymentSign_s) {
        this.paymentSign_s = paymentSign_s;
    }
}
