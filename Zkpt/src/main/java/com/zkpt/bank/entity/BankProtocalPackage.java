package com.zkpt.bank.entity;

import java.util.Date;

import com.zkpt.middleware.entity.IGenProtocalPackage;
import com.zkpt.util.DateUtils;

/***
 * 银行请求的协议包类
 * 
 * @author 赵琦
 *
 */
public class BankProtocalPackage implements IGenProtocalPackage, java.io.Serializable {
    private static final long serialVersionUID = -6704894633072481519L;
    private BankPacketHeadEntity packetHead; // 包头
    private String packetHead_s; //包头的字符串文件
    private String packetBody; // 数据包的字符串文件
    private BankCommand bankCommand; // 命令字
    private Long serverSessionKey; // 存储mina的客户端sessionId
    private String clientIp; // 客户端请求IP
    private int clientPort; // 客户端请求端口号
    private Date sentTime; // 客户端发送消息时间
    private BankParentReqEntity packetBodyEntity;

    public BankProtocalPackage() {
        packetHead = new BankPacketHeadEntity();
    }

    /**
     * 
     * @param packetHead
     * @param packetBody
     * @param bankCommand
     * @param serverSessionKey
     * @param clientIp
     * @param clientPort
     * @param sentTime
     * @param packetBodyEntity
     */
    public BankProtocalPackage(BankPacketHeadEntity packetHead, String packetBody, BankCommand bankCommand, Long serverSessionKey, String clientIp, int clientPort, Date sentTime,
            BankParentReqEntity packetBodyEntity) {
        super();
        this.packetHead = packetHead;
        this.packetBody = packetBody;
        this.bankCommand = bankCommand;
        this.serverSessionKey = serverSessionKey;
        this.clientIp = clientIp;
        this.clientPort = clientPort;
        this.sentTime = sentTime;
        this.packetBodyEntity = packetBodyEntity;
    }

    public BankPacketHeadEntity getPacketHead() {
        return packetHead;
    }

    public void setPacketHead(BankPacketHeadEntity packetHead) {
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

    public BankCommand getBankCommand() {
        return bankCommand;
    }

    public void setBankCommand(BankCommand bankCommand) {
        this.bankCommand = bankCommand;
    }

    public Long getServerSessionKey() {
        return serverSessionKey;
    }

    public void setServerSessionKey(Long serverSessionKey) {
        this.serverSessionKey = serverSessionKey;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public int getClientPort() {
        return clientPort;
    }

    public void setClientPort(int clientPort) {
        this.clientPort = clientPort;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public BankParentReqEntity getPacketBodyEntity() {
        return packetBodyEntity;
    }

    public void setPacketBodyEntity(BankParentReqEntity packetBodyEntity) {
        this.packetBodyEntity = packetBodyEntity;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("----------start 银行协议数据包----------").append("\n");
        sb.append("客户端(").append(clientIp).append(":").append(clientPort).append("...").append(DateUtils.date2Str(DateUtils.yyyymmddhhmmss)).append(")\n");
        sb.append("(String)数据格式:").append(packetHead.getFixedNumber_s()).append(packetHead.getPaymentCode_s()).append(packetHead.getPaymentPointPassword_s())
                .append(packetHead.getSpare_s()).append(packetHead.getTransactionMode_s()).append(packetHead.getTransactionFlow_s()).append(packetHead.getDataLength_s())
                .append(packetHead.getBaotouEnd_s()).append(packetBody).append("\n");
        sb.append("请求命令:").append(bankCommand).append("(").append(bankCommand.getKey()).append("|").append(bankCommand.getDesc()).append(")").append("\n");
        sb.append("mina会话Key:").append(serverSessionKey).append("\n");
        sb.append("交易包头内容:").append("\n");
        int i = 1;
        sb.append("\t").append(i++).append(") ").append("包头:").append(packetHead.getFixedNumber_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("缴费点代码:").append(packetHead.getPaymentCode_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("缴费点密码:").append(packetHead.getPaymentPointPassword_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("备用:").append(packetHead.getSpare_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("交易方式:").append(packetHead.getTransactionMode_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("交易流水号:").append(packetHead.getTransactionFlow_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("包体长度字节数:").append(packetHead.getDataLength_s()).append("\n");
        sb.append("\t").append(i++).append(") ").append("包头结束符:").append(packetHead.getBaotouEnd_s()).append("\n");
        sb.append("交易包内容:").append(packetBody).append("\n");
        sb.append("----------end 银行协议数据包----------").append("\n");
        return sb.toString();
    }
}
