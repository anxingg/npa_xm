package com.zkpt.util;

import org.apache.commons.net.ftp.FTPClientConfig;

public class FtpPropertiesEntity {
    /**
     * 传输过程hash显示。(add hash display during transfers)
     */
    private boolean printHash = false;
    /**
     * 设置处理文件上传或下载时的保持活动连接等待时间。（secs - use keep-alive timer）
     */
    private long keepAliveTimeout = -1;
    /**
     * 设置等待保持消息回复的时间。（msec - wait time for keep-alive reply）
     */
    private int controlKeepAliveReplyTimeout = -1;
    /**
     * 控制链接使用的字符编码。（encoding to use for control channel）
     */
    private String encoding = "UTF-8";
    /**
     * 隐藏文件。（list hidden files (applies to -l and -n only)）
     */
    private boolean hidden = false;
    /**
     * 使用二进制传输模式。（use binary transfer mode。in theory this should not be necessary as servers should
     * default to ASCII but they don't all do so - see NET-500）
     */
    private boolean binaryTransfer = true;
    /**
     * 主动模式还是被动模式。（Use passive mode as default because most of us are behind firewalls these days）
     */
    private boolean localActive = true;
    /**
     * 是否使用EPSV与IPv4。（use EPSV with IPv4 (default false)）
     */
    private boolean useEpsvWithIPv4 = false;
    /**
     * 文件系统类型。（systemType set server system type (e.g. UNIX VMS WINDOWS)）
     */
    private String serverType;
    /**
     * 保存不可回复的反应，如果解析失败，允许列表解析方法创建基本的ftp文件条目。（save unparseable response）
     */
    private boolean saveUnparseable;
    /**
     * 设置默认的时间格式化字符串，文件时间戳，FTPClientConfig 使用。（set default date format string）
     */
    private String defaultDateFormat;
    /**
     * 第二种时间格式字符串，文件时间戳，FTPClientConfig 使用。（set recent date format string）
     */
    private String recentDateFormat;
    /**
     * 抑制详细信息（suppress loggerin details）
     */
    private boolean debug = true;
    private FTPClientConfig config;

    public FtpPropertiesEntity() {

    }

    public FtpPropertiesEntity(boolean printHash, long keepAliveTimeout, int controlKeepAliveReplyTimeout, String encoding, boolean hidden, boolean binaryTransfer,
            boolean localActive, boolean useEpsvWithIPv4, String serverType, boolean saveUnparseable, String defaultDateFormat, String recentDateFormat, boolean debug) {
        this.printHash = printHash;
        this.keepAliveTimeout = keepAliveTimeout;
        this.controlKeepAliveReplyTimeout = controlKeepAliveReplyTimeout;
        this.encoding = encoding;
        this.hidden = hidden;
        this.binaryTransfer = binaryTransfer;
        this.localActive = localActive;
        this.useEpsvWithIPv4 = useEpsvWithIPv4;
        this.serverType = serverType;
        this.saveUnparseable = saveUnparseable;
        this.defaultDateFormat = defaultDateFormat;
        this.recentDateFormat = recentDateFormat;
        this.debug = debug;
    }

    public boolean isPrintHash() {
        return printHash;
    }

    public void setPrintHash(boolean printHash) {
        this.printHash = printHash;
    }

    public long getKeepAliveTimeout() {
        return keepAliveTimeout;
    }

    public void setKeepAliveTimeout(long keepAliveTimeout) {
        this.keepAliveTimeout = keepAliveTimeout;
    }

    public int getControlKeepAliveReplyTimeout() {
        return controlKeepAliveReplyTimeout;
    }

    public void setControlKeepAliveReplyTimeout(int controlKeepAliveReplyTimeout) {
        this.controlKeepAliveReplyTimeout = controlKeepAliveReplyTimeout;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isBinaryTransfer() {
        return binaryTransfer;
    }

    public void setBinaryTransfer(boolean binaryTransfer) {
        this.binaryTransfer = binaryTransfer;
    }

    public boolean isLocalActive() {
        return localActive;
    }

    public void setLocalActive(boolean localActive) {
        this.localActive = localActive;
    }

    public boolean isUseEpsvWithIPv4() {
        return useEpsvWithIPv4;
    }

    public void setUseEpsvWithIPv4(boolean useEpsvWithIPv4) {
        this.useEpsvWithIPv4 = useEpsvWithIPv4;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public boolean isSaveUnparseable() {
        return saveUnparseable;
    }

    public void setSaveUnparseable(boolean saveUnparseable) {
        this.saveUnparseable = saveUnparseable;
    }

    public String getDefaultDateFormat() {
        return defaultDateFormat;
    }

    public void setDefaultDateFormat(String defaultDateFormat) {
        this.defaultDateFormat = defaultDateFormat;
    }

    public String getRecentDateFormat() {
        return recentDateFormat;
    }

    public void setRecentDateFormat(String recentDateFormat) {
        this.recentDateFormat = recentDateFormat;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public FTPClientConfig getConfig() {
        if (serverType != null)
            config = new FTPClientConfig(serverType);
        else
            config = new FTPClientConfig();

        if (saveUnparseable)
            config.setUnparseableEntries(saveUnparseable);

        if (defaultDateFormat != null)
            config.setDefaultDateFormatStr(defaultDateFormat);

        if (recentDateFormat != null)
            config.setRecentDateFormatStr(recentDateFormat);

        return config;
    }

    public void setConfig(FTPClientConfig config) {
        this.config = config;
    }
}
