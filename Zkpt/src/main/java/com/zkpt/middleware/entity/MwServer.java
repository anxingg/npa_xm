package com.zkpt.middleware.entity;

/**
 * 服务器配置模型
 * 
 * @author zhaoqi
 *
 */
public class MwServer {
    private String localAddress; // 服务器监听地址
    private int port; // 服务器监听端口
    private int bufferSize; // 通道缓冲器大小
    private int idleTime; // Idle时间
    private String loggerFilterName; // 日志记录器名称
    private String referenceCountingFilterName; // 滤器被加入或移除过滤器链的次数的名称
    private String protocolCodecFilterName; // 解码器、编码器过滤器名称
    private String charSetName; // 编码器、解码器所使用的字符集

    public MwServer() {}

    /**
     * @param localAddress
     * @param port
     * @param bufferSize
     * @param idleTime
     * @param loggergerFilterName
     * @param referenceCountingFilterName
     * @param protocolCodecFilterName
     */
    public MwServer(String localAddress, int port, int bufferSize, int idleTime, String loggerFilterName, String referenceCountingFilterName, String protocolCodecFilterName,
            String charSetName) {
        this.localAddress = localAddress;
        this.port = port;
        this.bufferSize = bufferSize;
        this.idleTime = idleTime;
        this.loggerFilterName = loggerFilterName;
        this.referenceCountingFilterName = referenceCountingFilterName;
        this.protocolCodecFilterName = protocolCodecFilterName;
        this.charSetName = charSetName;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public String getLoggerFilterName() {
        return loggerFilterName;
    }

    public void setLoggerFilterName(String loggerFilterName) {
        this.loggerFilterName = loggerFilterName;
    }

    public String getReferenceCountingFilterName() {
        return referenceCountingFilterName;
    }

    public void setReferenceCountingFilterName(String referenceCountingFilterName) {
        this.referenceCountingFilterName = referenceCountingFilterName;
    }

    public String getProtocolCodecFilterName() {
        return protocolCodecFilterName;
    }

    public void setProtocolCodecFilterName(String protocolCodecFilterName) {
        this.protocolCodecFilterName = protocolCodecFilterName;
    }

    public String getCharSetName() {
        return charSetName;
    }

    public void setCharSetName(String charSetName) {
        this.charSetName = charSetName;
    }
}
