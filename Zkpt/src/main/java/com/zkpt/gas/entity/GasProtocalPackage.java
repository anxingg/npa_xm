package com.zkpt.gas.entity;

import java.util.Date;

import com.zkpt.middleware.entity.IGenProtocalPackage;

/**
 * 
 * @author 赵琦
 *
 */
public class GasProtocalPackage implements IGenProtocalPackage {
    private GasPacketHeadEntity packetHead; // 包头
    private String packetHead_s; // 包头的字符串文件
    private String packetBody; // 数据包的字符串文件
    private GasCommand gasCommand; // 命令字
    private Date echoTime; // 响应时间

    public GasProtocalPackage() {
        packetHead = new GasPacketHeadEntity();
    }

    /**
     * 
     * @param packetHead
     * @param packetBody
     * @param gasCommand
     * @param echoTime
     */
    public GasProtocalPackage(GasPacketHeadEntity packetHead, String packetBody, GasCommand gasCommand, Date echoTime) {
        super();
        this.packetHead = packetHead;
        this.packetBody = packetBody;
        this.gasCommand = gasCommand;
        this.echoTime = echoTime;
    }

    public GasPacketHeadEntity getPacketHead() {
        return packetHead;
    }

    public void setPacketHead(GasPacketHeadEntity packetHead) {
        this.packetHead = packetHead;
    }

    public String getPacketHead_s() {
        return packetHead_s;
    }

    public void setPacketHead_s(String packetHead_s) {
        this.packetHead_s = packetHead_s;
    }

    public String getPacketBody() {
        return packetBody;
    }

    public void setPacketBody(String packetBody) {
        this.packetBody = packetBody;
    }

    public GasCommand getGasCommand() {
        return gasCommand;
    }

    public void setGasCommand(GasCommand gasCommand) {
        this.gasCommand = gasCommand;
    }

    public Date getEchoTime() {
        return echoTime;
    }

    public void setEchoTime(Date echoTime) {
        this.echoTime = echoTime;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("----------start 天然气协议数据包----------").append("\n");
        sb.append("(String)数据格式:").append(packetHead.getRequestId_s()).append(packetHead.getBankNo_s()).append(packetHead.getBankDeviceNo_s()).append(packetHead.getBankBizSn_s())
                .append(packetHead.getTimeStamp_s()).append(packetHead.getRespondState_s()).append(packetHead.getDataLength_s()).append(packetHead.getIsNextPacket_s())
                .append(packetBody).append("\n");
        sb.append("请求命令:").append(gasCommand).append("(").append(gasCommand.getKey()).append("|").append(gasCommand.getDesc()).append(")").append("\n");
        sb.append("交易包头内容:").append("\n");
        int i = 1;
        sb.append("\t").append(i++).append(") ").append("请求标识，命令字:").append(packetHead.getRequestId_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("银行编号:").append(packetHead.getBankNo_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("银行设备编号:").append(packetHead.getBankDeviceNo_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("银行业务流水号:").append(packetHead.getBankBizSn_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("请求方或者响应方本地时间戳:").append(packetHead.getTimeStamp_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("响应字响应方回馈:").append(packetHead.getRespondState_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("包体长度字节数:").append(packetHead.getDataLength_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("是否有下一包:").append(packetHead.getIsNextPacket_s()).append("\n");
        sb.append("交易包内容:").append(packetBody).append("\n");
        sb.append("----------end 天然气协议数据包----------").append("\n");
        return sb.toString();
    }
}
