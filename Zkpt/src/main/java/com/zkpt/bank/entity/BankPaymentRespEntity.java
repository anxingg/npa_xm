package com.zkpt.bank.entity;

import java.util.ArrayList;
import java.util.List;

import com.zkpt.middleware.entity.CombinationIndex;
import com.zkpt.middleware.entity.ReplyParent;
import com.zkpt.util.TrickUitl;

/**
 * 交易缴费响应包
 * 
 * @author 赵琦
 *
 */
public class BankPaymentRespEntity implements ReplyParent, java.io.Serializable {
    private static final long serialVersionUID = 3343888169848714999L;

    private char[] transactionCode; // 交易码
    private char[] responseCode; // 响应码
    private char[] totalArrears; // 欠费总额
    private char[] userNo; // 用户编号
    private char[] userName; // 用户名称
    private char[] userAddress; // 用户地址
    private char[] protocolType; // 协议类型
    private char[] currSavings; // 上次节余
    private char[] userProperty; // 用户性质
    private char[] lastSavings; // 本次节余
    private char[] wasteFee; // 垃圾费
    private char[] maintenanceFee; // 维修费
    private char[] remark; // 备注
    private char[] gasConsumption; // 用气量
    private char[] gasFee; // 气费
    private char[] collectionFee; // 代收费
    private char[] surcharge1; // 附加费1
    private char[] penalty; // 违约金
    private char[] surcharge2; // 附加费2
    private char[] startMonth; // 开始月份
    private char[] endMonth; // 终止月份
    private char[] lastRead; // 上次读数
    private char[] reading; // 本次读数
    private char[] lastReadTime; // 上次抄表时间
    private char[] readingTime; // 本次抄表时间
    private char[] payableAmount; // 本次缴费
    private char[] detailTimes; // 明细次数

    @CombinationIndex(index = 1)
    private String transactionCode_s;
    @CombinationIndex(index = 2)
    private String responseCode_s;
    @CombinationIndex(index = 3)
    private Double totalArrears_s;
    @CombinationIndex(index = 4)
    private String userNo_s;
    @CombinationIndex(index = 5)
    private String userName_s;
    @CombinationIndex(index = 6)
    private String userAddress_s;
    @CombinationIndex(index = 7)
    private String protocolType_s;
    @CombinationIndex(index = 8)
    private String currSavings_s;
    @CombinationIndex(index = 9)
    private String lastSavings_s;
    @CombinationIndex(index = 10)
    private String userProperty_s;
    @CombinationIndex(index = 11)
    private Double wasteFee_s;
    @CombinationIndex(index = 12)
    private Double maintenanceFee_s;
    @CombinationIndex(index = 13)
    private String remark_s;
    @CombinationIndex(index = 14)
    private Double gasConsumption_s;
    @CombinationIndex(index = 15)
    private Double gasFee_s;
    @CombinationIndex(index = 16)
    private Double collectionFee_s;
    @CombinationIndex(index = 17)
    private Double surcharge1_s;
    @CombinationIndex(index = 18)
    private Double penalty_s;
    @CombinationIndex(index = 19)
    private Double surcharge2_s;
    @CombinationIndex(index = 20)
    private String startMonth_s;
    @CombinationIndex(index = 21)
    private String endMonth_s;
    @CombinationIndex(index = 22)
    private Double lastRead_s;
    @CombinationIndex(index = 23)
    private Double reading_s;
    @CombinationIndex(index = 24)
    private String lastReadTime_s;
    @CombinationIndex(index = 25)
    private String readingTime_s;
    @CombinationIndex(index = 26)
    private Double payableAmount_s;
    @CombinationIndex(index = 27)
    private Integer detailTimes_s;
    @CombinationIndex(index = 28)
    private List<BankPaymentRespDetailEntity> list; // 天然气账单明细

    private BankPaymentRespEntity self; // 自己的对象指针

    public BankPaymentRespEntity() {
        transactionCode = new char[] {};
        responseCode = new char[] {};
        totalArrears = new char[] {};
        userNo = new char[] {};
        userName = new char[] {};
        userAddress = new char[] {};
        protocolType = new char[] {};
        currSavings = new char[] {};
        userProperty = new char[] {};
        lastSavings = new char[] {};
        wasteFee = new char[] {};
        maintenanceFee = new char[] {};
        remark = new char[] {};
        gasConsumption = new char[] {};
        gasFee = new char[] {};
        collectionFee = new char[] {};
        surcharge1 = new char[] {};
        penalty = new char[] {};
        surcharge2 = new char[] {};
        startMonth = new char[] {};
        endMonth = new char[] {};
        lastRead = new char[] {};
        reading = new char[] {};
        lastReadTime = new char[] {};
        readingTime = new char[] {};
        payableAmount = new char[] {};
        detailTimes = new char[] {'0'};
        transactionCode_s = "";
        responseCode_s = "";
        totalArrears_s = null;
        userNo_s = "";
        userName_s = "";
        userAddress_s = "";
        protocolType_s = "";
        currSavings_s = "";
        lastSavings_s = "";
        userProperty_s = "";
        wasteFee_s = null;
        maintenanceFee_s = null;
        remark_s = "";
        gasConsumption_s = null;
        gasFee_s = null;
        collectionFee_s = null;
        surcharge1_s = null;
        penalty_s = null;
        surcharge2_s = null;
        startMonth_s = "";
        endMonth_s = "";
        lastRead_s = null;
        reading_s = null;
        lastReadTime_s = "";
        readingTime_s = "";
        payableAmount_s = null;
        detailTimes_s = new Integer(0);
        list = new ArrayList<BankPaymentRespDetailEntity>();
    }

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

    public char[] getTotalArrears() {
        return totalArrears;
    }

    public void setTotalArrears(char[] totalArrears) {
        this.totalArrears = totalArrears;
    }

    public char[] getUserNo() {
        return userNo;
    }

    public void setUserNo(char[] userNo) {
        this.userNo = userNo;
    }

    public char[] getUserName() {
        return userName;
    }

    public void setUserName(char[] userName) {
        this.userName = userName;
    }

    public char[] getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(char[] userAddress) {
        this.userAddress = userAddress;
    }

    public char[] getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(char[] protocolType) {
        this.protocolType = protocolType;
    }

    public char[] getCurrSavings() {
        return currSavings;
    }

    public void setCurrSavings(char[] currSavings) {
        this.currSavings = currSavings;
    }

    public char[] getUserProperty() {
        return userProperty;
    }

    public void setUserProperty(char[] userProperty) {
        this.userProperty = userProperty;
    }

    public char[] getLastSavings() {
        return lastSavings;
    }

    public void setLastSavings(char[] lastSavings) {
        this.lastSavings = lastSavings;
    }

    public char[] getWasteFee() {
        return wasteFee;
    }

    public void setWasteFee(char[] wasteFee) {
        this.wasteFee = wasteFee;
    }

    public char[] getMaintenanceFee() {
        return maintenanceFee;
    }

    public void setMaintenanceFee(char[] maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }

    public char[] getRemark() {
        return remark;
    }

    public void setRemark(char[] remark) {
        this.remark = remark;
    }

    public char[] getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(char[] gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    public char[] getGasFee() {
        return gasFee;
    }

    public void setGasFee(char[] gasFee) {
        this.gasFee = gasFee;
    }

    public char[] getCollectionFee() {
        return collectionFee;
    }

    public void setCollectionFee(char[] collectionFee) {
        this.collectionFee = collectionFee;
    }

    public char[] getSurcharge1() {
        return surcharge1;
    }

    public void setSurcharge1(char[] surcharge1) {
        this.surcharge1 = surcharge1;
    }

    public char[] getPenalty() {
        return penalty;
    }

    public void setPenalty(char[] penalty) {
        this.penalty = penalty;
    }

    public char[] getSurcharge2() {
        return surcharge2;
    }

    public void setSurcharge2(char[] surcharge2) {
        this.surcharge2 = surcharge2;
    }

    public char[] getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(char[] startMonth) {
        this.startMonth = startMonth;
    }

    public char[] getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(char[] endMonth) {
        this.endMonth = endMonth;
    }

    public char[] getLastRead() {
        return lastRead;
    }

    public void setLastRead(char[] lastRead) {
        this.lastRead = lastRead;
    }

    public char[] getReading() {
        return reading;
    }

    public void setReading(char[] reading) {
        this.reading = reading;
    }

    public char[] getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(char[] lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public char[] getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(char[] readingTime) {
        this.readingTime = readingTime;
    }

    public char[] getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(char[] payableAmount) {
        this.payableAmount = payableAmount;
    }

    public char[] getDetailTimes() {
        return detailTimes;
    }

    public void setDetailTimes(char[] detailTimes) {
        this.detailTimes = detailTimes;
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

    public Double getTotalArrears_s() {
        return totalArrears_s;
    }

    public void setTotalArrears_s(Double totalArrears_s) {
        this.totalArrears_s = totalArrears_s;
    }

    public String getUserNo_s() {
        return userNo_s;
    }

    public void setUserNo_s(String userNo_s) {
        this.userNo_s = userNo_s;
    }

    public String getUserName_s() {
        return userName_s;
    }

    public void setUserName_s(String userName_s) {
        this.userName_s = userName_s;
    }

    public String getUserAddress_s() {
        return userAddress_s;
    }

    public void setUserAddress_s(String userAddress_s) {
        this.userAddress_s = userAddress_s;
    }

    public String getProtocolType_s() {
        return protocolType_s;
    }

    public void setProtocolType_s(String protocolType_s) {
        this.protocolType_s = protocolType_s;
    }

    public String getCurrSavings_s() {
        return currSavings_s;
    }

    public void setCurrSavings_s(String currSavings_s) {
        this.currSavings_s = currSavings_s;
    }

    public String getUserProperty_s() {
        return userProperty_s;
    }

    public void setUserProperty_s(String userProperty_s) {
        this.userProperty_s = userProperty_s;
    }

    public String getLastSavings_s() {
        return lastSavings_s;
    }

    public void setLastSavings_s(String lastSavings_s) {
        this.lastSavings_s = lastSavings_s;
    }

    public Double getWasteFee_s() {
        return wasteFee_s;
    }

    public void setWasteFee_s(Double wasteFee_s) {
        this.wasteFee_s = wasteFee_s;
    }

    public Double getMaintenanceFee_s() {
        return maintenanceFee_s;
    }

    public void setMaintenanceFee_s(Double maintenanceFee_s) {
        this.maintenanceFee_s = maintenanceFee_s;
    }

    public String getRemark_s() {
        return remark_s;
    }

    public void setRemark_s(String remark_s) {
        this.remark_s = remark_s;
    }

    public Double getGasConsumption_s() {
        return gasConsumption_s;
    }

    public void setGasConsumption_s(Double gasConsumption_s) {
        this.gasConsumption_s = gasConsumption_s;
    }

    public Double getGasFee_s() {
        return gasFee_s;
    }

    public void setGasFee_s(Double gasFee_s) {
        this.gasFee_s = gasFee_s;
    }

    public Double getCollectionFee_s() {
        return collectionFee_s;
    }

    public void setCollectionFee_s(Double collectionFee_s) {
        this.collectionFee_s = collectionFee_s;
    }

    public Double getSurcharge1_s() {
        return surcharge1_s;
    }

    public void setSurcharge1_s(Double surcharge1_s) {
        this.surcharge1_s = surcharge1_s;
    }

    public Double getPenalty_s() {
        return penalty_s;
    }

    public void setPenalty_s(Double penalty_s) {
        this.penalty_s = penalty_s;
    }

    public Double getSurcharge2_s() {
        return surcharge2_s;
    }

    public void setSurcharge2_s(Double surcharge2_s) {
        this.surcharge2_s = surcharge2_s;
    }

    public String getStartMonth_s() {
        return startMonth_s;
    }

    public void setStartMonth_s(String startMonth_s) {
        this.startMonth_s = startMonth_s;
    }

    public String getEndMonth_s() {
        return endMonth_s;
    }

    public void setEndMonth_s(String endMonth_s) {
        this.endMonth_s = endMonth_s;
    }

    public Double getLastRead_s() {
        return lastRead_s;
    }

    public void setLastRead_s(Double lastRead_s) {
        this.lastRead_s = lastRead_s;
    }

    public Double getReading_s() {
        return reading_s;
    }

    public void setReading_s(Double reading_s) {
        this.reading_s = reading_s;
    }

    public String getLastReadTime_s() {
        return lastReadTime_s;
    }

    public void setLastReadTime_s(String lastReadTime_s) {
        this.lastReadTime_s = lastReadTime_s;
    }

    public String getReadingTime_s() {
        return readingTime_s;
    }

    public void setReadingTime_s(String readingTime_s) {
        this.readingTime_s = readingTime_s;
    }

    public Double getPayableAmount_s() {
        return payableAmount_s;
    }

    public void setPayableAmount_s(Double payableAmount_s) {
        this.payableAmount_s = payableAmount_s;
    }

    public Integer getDetailTimes_s() {
        return detailTimes_s;
    }

    public void setDetailTimes_s(Integer detailTimes_s) {
        this.detailTimes_s = detailTimes_s;
    }

    public List<BankPaymentRespDetailEntity> getList() {
        return list;
    }

    public void setList(List<BankPaymentRespDetailEntity> list) {
        this.list = list;
    }

    public BankPaymentRespEntity getSelf() {
        return self;
    }

    public void setSelf(BankPaymentRespEntity self) {
        this.self = self;
    }

    @Override
    public String reply() {
        return TrickUitl.reply_resp_combination(self);
    }
}
