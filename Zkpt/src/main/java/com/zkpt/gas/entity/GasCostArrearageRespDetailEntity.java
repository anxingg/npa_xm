package com.zkpt.gas.entity;

/**
 * 查询气费欠费信息(响应包-明细)
 * 
 * @author 赵琦
 *
 */
public class GasCostArrearageRespDetailEntity implements java.io.Serializable {
    private static final long serialVersionUID = -8561910611380029758L;
    
    private char[] userNo; // 用户号
    private char[] month; // 气费月份
    private char[] prevVal; // 上次示度
    private char[] currVal; // 本次示度
    private char[] airVal; // 气量
    private char[] airCost; // 气费
    private char[] payAbleAirNum; // 应缴气费
    private char[] lateFee; // 滞纳金
    private char[] payAbleAirCost; // 应缴费用
    private char[] airVal1; // 气量1
    private char[] airCost1; // 气价1
    private char[] airVal2; // 气量2
    private char[] airCost2;// 气价2
    private char[] airVal3; // 气量3
    private char[] airCost3;// 气价3
    private char[] airVal4; // 气量4
    private char[] airCost4;// 气价4

    private String userNo_s;
    private String month_s;
    private String prevVal_s;
    private String currVal_s;
    private String airVal_s;
    private String airCost_s;
    private String payAbleAirNum_s;
    private String lateFee_s;
    private String payAbleAirCost_s;
    private String airVal1_s;
    private String airCost1_s;
    private String airVal2_s;
    private String airCost2_s;
    private String airVal3_s;
    private String airCost3_s;
    private String airVal4_s;
    private String airCost4_s;

    public char[] getUserNo() {
        return userNo;
    }

    public void setUserNo(char[] userNo) {
        this.userNo = userNo;
    }

    public char[] getMonth() {
        return month;
    }

    public void setMonth(char[] month) {
        this.month = month;
    }

    public char[] getPrevVal() {
        return prevVal;
    }

    public void setPrevVal(char[] prevVal) {
        this.prevVal = prevVal;
    }

    public char[] getCurrVal() {
        return currVal;
    }

    public void setCurrVal(char[] currVal) {
        this.currVal = currVal;
    }

    public char[] getAirVal() {
        return airVal;
    }

    public void setAirVal(char[] airVal) {
        this.airVal = airVal;
    }

    public char[] getAirCost() {
        return airCost;
    }

    public void setAirCost(char[] airCost) {
        this.airCost = airCost;
    }

    public char[] getPayAbleAirNum() {
        return payAbleAirNum;
    }

    public void setPayAbleAirNum(char[] payAbleAirNum) {
        this.payAbleAirNum = payAbleAirNum;
    }

    public char[] getLateFee() {
        return lateFee;
    }

    public void setLateFee(char[] lateFee) {
        this.lateFee = lateFee;
    }

    public char[] getPayAbleAirCost() {
        return payAbleAirCost;
    }

    public void setPayAbleAirCost(char[] payAbleAirCost) {
        this.payAbleAirCost = payAbleAirCost;
    }

    public char[] getAirVal1() {
        return airVal1;
    }

    public void setAirVal1(char[] airVal1) {
        this.airVal1 = airVal1;
    }

    public char[] getAirCost1() {
        return airCost1;
    }

    public void setAirCost1(char[] airCost1) {
        this.airCost1 = airCost1;
    }

    public char[] getAirVal2() {
        return airVal2;
    }

    public void setAirVal2(char[] airVal2) {
        this.airVal2 = airVal2;
    }

    public char[] getAirCost2() {
        return airCost2;
    }

    public void setAirCost2(char[] airCost2) {
        this.airCost2 = airCost2;
    }

    public char[] getAirVal3() {
        return airVal3;
    }

    public void setAirVal3(char[] airVal3) {
        this.airVal3 = airVal3;
    }

    public char[] getAirCost3() {
        return airCost3;
    }

    public void setAirCost3(char[] airCost3) {
        this.airCost3 = airCost3;
    }

    public char[] getAirVal4() {
        return airVal4;
    }

    public void setAirVal4(char[] airVal4) {
        this.airVal4 = airVal4;
    }

    public char[] getAirCost4() {
        return airCost4;
    }

    public void setAirCost4(char[] airCost4) {
        this.airCost4 = airCost4;
    }

    public String getUserNo_s() {
        return userNo_s;
    }

    public void setUserNo_s(String userNo_s) {
        this.userNo_s = userNo_s;
    }

    public String getMonth_s() {
        return month_s;
    }

    public void setMonth_s(String month_s) {
        this.month_s = month_s;
    }

    public String getPrevVal_s() {
        return prevVal_s;
    }

    public void setPrevVal_s(String prevVal_s) {
        this.prevVal_s = prevVal_s;
    }

    public String getCurrVal_s() {
        return currVal_s;
    }

    public void setCurrVal_s(String currVal_s) {
        this.currVal_s = currVal_s;
    }

    public String getAirVal_s() {
        return airVal_s;
    }

    public void setAirVal_s(String airVal_s) {
        this.airVal_s = airVal_s;
    }

    public String getAirCost_s() {
        return airCost_s;
    }

    public void setAirCost_s(String airCost_s) {
        this.airCost_s = airCost_s;
    }

    public String getPayAbleAirNum_s() {
        return payAbleAirNum_s;
    }

    public void setPayAbleAirNum_s(String payAbleAirNum_s) {
        this.payAbleAirNum_s = payAbleAirNum_s;
    }

    public String getLateFee_s() {
        return lateFee_s;
    }

    public void setLateFee_s(String lateFee_s) {
        this.lateFee_s = lateFee_s;
    }

    public String getPayAbleAirCost_s() {
        return payAbleAirCost_s;
    }

    public void setPayAbleAirCost_s(String payAbleAirCost_s) {
        this.payAbleAirCost_s = payAbleAirCost_s;
    }

    public String getAirVal1_s() {
        return airVal1_s;
    }

    public void setAirVal1_s(String airVal1_s) {
        this.airVal1_s = airVal1_s;
    }

    public String getAirCost1_s() {
        return airCost1_s;
    }

    public void setAirCost1_s(String airCost1_s) {
        this.airCost1_s = airCost1_s;
    }

    public String getAirVal2_s() {
        return airVal2_s;
    }

    public void setAirVal2_s(String airVal2_s) {
        this.airVal2_s = airVal2_s;
    }

    public String getAirCost2_s() {
        return airCost2_s;
    }

    public void setAirCost2_s(String airCost2_s) {
        this.airCost2_s = airCost2_s;
    }

    public String getAirVal3_s() {
        return airVal3_s;
    }

    public void setAirVal3_s(String airVal3_s) {
        this.airVal3_s = airVal3_s;
    }

    public String getAirCost3_s() {
        return airCost3_s;
    }

    public void setAirCost3_s(String airCost3_s) {
        this.airCost3_s = airCost3_s;
    }

    public String getAirVal4_s() {
        return airVal4_s;
    }

    public void setAirVal4_s(String airVal4_s) {
        this.airVal4_s = airVal4_s;
    }

    public String getAirCost4_s() {
        return airCost4_s;
    }

    public void setAirCost4_s(String airCost4_s) {
        this.airCost4_s = airCost4_s;
    }
}
