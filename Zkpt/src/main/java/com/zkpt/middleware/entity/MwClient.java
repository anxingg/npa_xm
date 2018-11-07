package com.zkpt.middleware.entity;

/**
 * 客户端配置模型
 * 
 * @author zhaoqi
 *
 */
public class MwClient {
    private String inetSocketAddress; // 目标通讯地址
    private int port; // 目标通讯端口
    private int connectTimeoutMillis; // 连接超时时间
    private String loggerFilterName; // 日志记录器名称
    private String referenceCountingFilterName; // 滤器被加入或移除过滤器链的次数的名称
    private String protocolCodecFilterName; // 解码器、编码器过滤器名称
    private String charSetName; // 编码器、解码器所使用的字符集
    private int readBufferSize; // 缓冲区的大小
    private int bothIdle; // 读写都空闲时间
    private int readerIdle; // 读空闲时间
    private int writerIdle; // 写空闲时间

    public MwClient() {}

    /**
     * 
     * @param inetSocketAddress
     * @param port
     * @param connectTimeoutMillis
     * @param loggerFilterName
     * @param referenceCountingFilterName
     * @param protocolCodecFilterName
     * @param charSetName
     * @param receiveBufferSize
     * @param sendBufferSize
     * @param bothIdle
     * @param readerIdle
     * @param writerIdle
     */
    public MwClient(String inetSocketAddress, int port, int connectTimeoutMillis, String loggerFilterName, String referenceCountingFilterName, String protocolCodecFilterName,
            String charSetName, int readBufferSize, int bothIdle, int readerIdle, int writerIdle) {
        super();
        this.inetSocketAddress = inetSocketAddress;
        this.port = port;
        this.connectTimeoutMillis = connectTimeoutMillis;
        this.loggerFilterName = loggerFilterName;
        this.referenceCountingFilterName = referenceCountingFilterName;
        this.protocolCodecFilterName = protocolCodecFilterName;
        this.charSetName = charSetName;
        this.readBufferSize = readBufferSize;
        this.bothIdle = bothIdle;
        this.readerIdle = readerIdle;
        this.writerIdle = writerIdle;
    }



    public String getInetSocketAddress() {
        return inetSocketAddress;
    }

    public void setInetSocketAddress(String inetSocketAddress) {
        this.inetSocketAddress = inetSocketAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getConnectTimeoutMillis() {
        return connectTimeoutMillis;
    }

    public void setConnectTimeoutMillis(int connectTimeoutMillis) {
        this.connectTimeoutMillis = connectTimeoutMillis;
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

    public int getReadBufferSize() {
        return readBufferSize;
    }

    public void setReadBufferSize(int readBufferSize) {
        this.readBufferSize = readBufferSize;
    }

    public int getBothIdle() {
        return bothIdle;
    }

    public void setBothIdle(int bothIdle) {
        this.bothIdle = bothIdle;
    }

    public int getReaderIdle() {
        return readerIdle;
    }

    public void setReaderIdle(int readerIdle) {
        this.readerIdle = readerIdle;
    }

    public int getWriterIdle() {
        return writerIdle;
    }

    public void setWriterIdle(int writerIdle) {
        this.writerIdle = writerIdle;
    }
}
