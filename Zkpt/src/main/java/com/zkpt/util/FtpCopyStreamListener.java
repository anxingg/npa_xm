package com.zkpt.util;

import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 进度监听器
 * 
 * @author zhaoqi
 *
 */
public class FtpCopyStreamListener implements CopyStreamListener {
    private final static Logger logger = LoggerFactory.getLogger(FtpCopyStreamListener.class);
    private long totalSize = 0;
    private long percent = -1; // 进度

    /**
     * 文件的总大小
     * 
     * @param totalSize
     */
    public FtpCopyStreamListener(long totalSize) {
        super();
        this.totalSize = totalSize;
    }

    @Override
    public void bytesTransferred(CopyStreamEvent event) {
        bytesTransferred(event.getTotalBytesTransferred(), event.getBytesTransferred(), event.getStreamSize());
    }

    // totalBytesTransferred:当前总共已传输字节数;
    // bytesTransferred:最近一次传输字节数
    @Override
    public void bytesTransferred(long totalBytesTransferred, int bytesTransferred, long streamSize) {
        if (percent >= totalBytesTransferred * 100 / totalSize) {
            return;
        }
        percent = totalBytesTransferred * 100 / totalSize;
        logger.info("Completed " + totalBytesTransferred + "(" + percent + "%) out of " + totalSize + ".");
    }

}
