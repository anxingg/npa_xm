package com.zkpt.bank.entity;

import com.zkpt.middleware.entity.CombinationIndex;

/**
 * 交易缴费响应包Detial明细
 * 
 * @author 赵琦
 *
 */
public class BankPaymentRespDetailEntity implements java.io.Serializable {
    private static final long serialVersionUID = 1950493443451662279L;

    private char[] meterReadingTime; // 抄表时间
    private char[] startCode; // 起码
    private char[] stopCode; // 止码
    private char[] practicalTonnage; // 实用吨数
    private char[] penalty; // 违约金
    private char[] wasteFee; // 垃圾费
    private char[] currSavings; // 上次节余
    private char[] lastSavings; // 本次节余
    private char[] currActual; // 本月实收
    private char[] currArrearsTotal; // 本月欠费总额

    @CombinationIndex(index = 1)
    private String meterReadingTime_s = "";
    @CombinationIndex(index = 2)
    private String startCode_s = "";
    @CombinationIndex(index = 3)
    private String stopCode_s = "";
    @CombinationIndex(index = 4)
    private Double practicalTonnage_s;
    @CombinationIndex(index = 5)
    private Double penalty_s;
    @CombinationIndex(index = 6)
    private Double wasteFee_s;
    @CombinationIndex(index = 7)
    private Double currSavings_s;
    @CombinationIndex(index = 8)
    private Double lastSavings_s;
    @CombinationIndex(index = 9)
    private Double currActual_s;
    @CombinationIndex(index = 10)
    private Double currArrearsTotal_s;

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

    public char[] getWasteFee() {
        return wasteFee;
    }

    public void setWasteFee(char[] wasteFee) {
        this.wasteFee = wasteFee;
    }

    public char[] getCurrSavings() {
        return currSavings;
    }

    public void setCurrSavings(char[] currSavings) {
        this.currSavings = currSavings;
    }

    public char[] getLastSavings() {
        return lastSavings;
    }

    public void setLastSavings(char[] lastSavings) {
        this.lastSavings = lastSavings;
    }

    public char[] getCurrActual() {
        return currActual;
    }

    public void setCurrActual(char[] currActual) {
        this.currActual = currActual;
    }

    public char[] getCurrArrearsTotal() {
        return currArrearsTotal;
    }

    public void setCurrArrearsTotal(char[] currArrearsTotal) {
        this.currArrearsTotal = currArrearsTotal;
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

    public Double getWasteFee_s() {
        return wasteFee_s;
    }

    public void setWasteFee_s(Double wasteFee_s) {
        this.wasteFee_s = wasteFee_s;
    }

    public Double getCurrSavings_s() {
        return currSavings_s;
    }

    public void setCurrSavings_s(Double currSavings_s) {
        this.currSavings_s = currSavings_s;
    }

    public Double getLastSavings_s() {
        return lastSavings_s;
    }

    public void setLastSavings_s(Double lastSavings_s) {
        this.lastSavings_s = lastSavings_s;
    }

    public Double getCurrActual_s() {
        return currActual_s;
    }

    public void setCurrActual_s(Double currActual_s) {
        this.currActual_s = currActual_s;
    }

    public Double getCurrArrearsTotal_s() {
        return currArrearsTotal_s;
    }

    public void setCurrArrearsTotal_s(Double currArrearsTotal_s) {
        this.currArrearsTotal_s = currArrearsTotal_s;
    }

}
