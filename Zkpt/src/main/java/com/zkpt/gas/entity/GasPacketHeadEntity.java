package com.zkpt.gas.entity;

/**
 * 周口燃气银行接口数据包头
 * 
 * @author 赵琦
 *
 */
public class GasPacketHeadEntity {
    private char[] requestId; // 请求标识，命令字（主命令+子命令字），响应方需原样返回
    private char[] bankNo; // 银行编号，只有银行端需要填写 000-255
    private char[] bankDeviceNo; // 银行设备编号，最长10位，不足前补0
    private char[] bankBizSn; // 银行业务流水号，最长10位，不足前补0
    private char[] timeStamp; // 请求方或者响应方本地时间戳"yyyymmmddhhnnss"
    private char[] respondState; // 响应字响应方回馈，0000代表成功，其他为错误码
    private char[] DataLength; // 包体长度字节数，00000-65535
    private char[] isNextPacket; // 是否有下一包 0 沒有 1 有

    private String requestId_s;
    private String bankNo_s;
    private String bankDeviceNo_s;
    private String bankBizSn_s;
    private String timeStamp_s;
    private String respondState_s;
    private String DataLength_s;
    private String isNextPacket_s;

    public GasPacketHeadEntity() {}

    public char[] getRequestId() {
        return requestId;
    }

    public void setRequestId(char[] requestId) {
        this.requestId = requestId;
    }

    public char[] getBankNo() {
        return bankNo;
    }

    public void setBankNo(char[] bankNo) {
        this.bankNo = bankNo;
    }

    public char[] getBankDeviceNo() {
        return bankDeviceNo;
    }

    public void setBankDeviceNo(char[] bankDeviceNo) {
        this.bankDeviceNo = bankDeviceNo;
    }

    public char[] getBankBizSn() {
        return bankBizSn;
    }

    public void setBankBizSn(char[] bankBizSn) {
        this.bankBizSn = bankBizSn;
    }

    public char[] getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(char[] timeStamp) {
        this.timeStamp = timeStamp;
    }

    public char[] getRespondState() {
        return respondState;
    }

    public void setRespondState(char[] respondState) {
        this.respondState = respondState;
    }

    public char[] getDataLength() {
        return DataLength;
    }

    public void setDataLength(char[] dataLength) {
        DataLength = dataLength;
    }

    public char[] getIsNextPacket() {
        return isNextPacket;
    }

    public void setIsNextPacket(char[] isNextPacket) {
        this.isNextPacket = isNextPacket;
    }

    public String getRequestId_s() {
        return requestId_s;
    }

    public void setRequestId_s(String requestId_s) {
        this.requestId_s = requestId_s;
    }

    public String getBankNo_s() {
        return bankNo_s;
    }

    public void setBankNo_s(String bankNo_s) {
        this.bankNo_s = bankNo_s;
    }

    public String getBankDeviceNo_s() {
        return bankDeviceNo_s;
    }

    public void setBankDeviceNo_s(String bankDeviceNo_s) {
        this.bankDeviceNo_s = bankDeviceNo_s;
    }

    public String getBankBizSn_s() {
        return bankBizSn_s;
    }

    public void setBankBizSn_s(String bankBizSn_s) {
        this.bankBizSn_s = bankBizSn_s;
    }

    public String getTimeStamp_s() {
        return timeStamp_s;
    }

    public void setTimeStamp_s(String timeStamp_s) {
        this.timeStamp_s = timeStamp_s;
    }

    public String getRespondState_s() {
        return respondState_s;
    }

    public void setRespondState_s(String respondState_s) {
        this.respondState_s = respondState_s;
    }

    public String getDataLength_s() {
        return DataLength_s;
    }

    public void setDataLength_s(String dataLength_s) {
        DataLength_s = dataLength_s;
    }

    public String getIsNextPacket_s() {
        return isNextPacket_s;
    }

    public void setIsNextPacket_s(String isNextPacket_s) {
        this.isNextPacket_s = isNextPacket_s;
    }
}
