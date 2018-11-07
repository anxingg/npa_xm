package com.zkpt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.SocketException;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.util.TrustManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FtpUtil {
    private final static Logger logger = LoggerFactory.getLogger(FtpUtil.class);

    public static final String USAGE = "Expected Parameters: [options] <hostname> <username> <password> [<remote file> [<local file>]]\n"
            + "\nDefault behavior is to download a file and use ASCII transfer mode.\n" + // 下载文件默认使用ASCII传输模式
            "\t-a - use local active mode (default is local passive)\n" + // 使用本地活动用户模式（本地的用户密码）
            "\t-A - anonymous login (omit username and password parameters)\n" + "\t-b - use binary transfer mode\n" + // 使用二进制传输模式
            "\t-c cmd - issue arbitrary command (remote is used as a parameter if provided) \n" + // 发送任意命令
            "\t-d - list directory details using MLSD (remote is used as the pathname if provided)\n" + "\t-f - issue FEAT command (remote and local files are ignored)\n" + // 发送FEAT命令
            "\t-l - list files using LIST (remote is used as the pathname if provided)\n" + "\t     Files are listed twice: first in raw mode, then as the formatted parsed data.\n"
            + "\t     N.B. if the wrong server-type is used, output may be lost. Use -U or -S as necessary.\n"
            + "\t-L - use lenient future dates (server dates may be up to 1 day into future)\n"
            + "\t-m - list file details using MDTM (remote is used as the pathname if provided)\n"
            + "\t-n - list file names using NLST (remote is used as the pathname if provided)\n"
            + "\t-p true|false|protocol[,true|false] - use FTPSClient with the specified protocol and/or isImplicit setting\n" // 使用FTPS客户端，并根据特定的协议隐式设置
            + "\t-s - store file on server (upload)\n" + "\t-t - list file details using MLST (remote is used as the pathname if provided)\n"
            + "\t-T  all|valid|none - use one of the built-in TrustManager implementations (none = JVM default)\n" // 使用指定的TrustManager（使用protocal的时候可以指定，默认为none）
            + "\t-Z timezone - set the server timezone for parsing LIST responses\n" + "\t-z timezone - set the timezone for displaying MDTM, LIST, MLSD, MLST responses\n"
            + "\t-PrH server[:port] - HTTP Proxy host and optional port[80] \n" // Http协议类型服务端地址和端口号: <ip>:<port>
            + "\t-PrU user - HTTP Proxy server username\n" // Http协议类型服务端用户名
            + "\t-PrP password - HTTP Proxy server password\n"; // Http协议类型服务端密码

    /**
     * 标准类型FTP客户端
     * 
     * @param server
     * @param port
     * @param user
     * @param password
     * @return
     * @throws Exception
     */
    public FTPClient getFTPClient(String server, int port, String user, String password) throws Exception {
        return getFTPClient(server, port, user, password, new FtpPropertiesEntity());
    }

    /**
     * 标准类型FTP客户端（可配置config）
     * 
     * @param server
     * @param port
     * @param user
     * @param password
     * @param ftpProperties
     * @return
     * @throws Exception
     */
    public FTPClient getFTPClient(String server, int port, String user, String password, FtpPropertiesEntity ftpProperties) throws Exception {
        FTPClient ftp = new FTPClient();
        setOtherProp(ftp, ftpProperties);
        ftp.configure(ftpProperties.getConfig());
        return ftp;
    }

    /**
     * 代理类型的FTP客户端
     * 
     * @param proxyHost
     * @param proxyPort
     * @param proxyUser
     * @param proxyPassword
     * @return
     * @throws Exception
     */
    public FTPClient getFTPHTTPClient(String proxyHost, int proxyPort, String proxyUser, String proxyPassword) throws Exception {
        return getFTPHTTPClient(proxyHost, proxyPort, proxyUser, proxyPassword, new FtpPropertiesEntity());
    }


    /**
     * 代理类型的FTP客户端 （可配置config）
     * 
     * @param proxyHost
     * @param proxyPort
     * @param proxyUser
     * @param proxyPassword
     * @param ftpProperties
     * @return
     * @throws Exception
     */
    public FTPClient getFTPHTTPClient(String proxyHost, int proxyPort, String proxyUser, String proxyPassword, FtpPropertiesEntity ftpProperties) throws Exception {
        FTPClient ftp = new FTPHTTPClient(proxyHost, proxyPort, proxyUser, proxyPassword);
        setOtherProp(ftp, ftpProperties);
        ftp.configure(ftpProperties.getConfig());
        return ftp;
    }

    /**
     * 隐藏SSL、公开SSL（验证SSL）、公开SSL（验证TLS）
     * 
     * @param protocol
     * @param trustmgr
     * @param server
     * @param port
     * @param user
     * @param password
     * @return
     * @throws Exception
     */
    public FTPClient getFTPSClient(String protocol, String trustmgr, String server, int port, String user, String password) throws Exception {
        return getFTPSClient(protocol, trustmgr, server, port, user, password, new FtpPropertiesEntity());
    }

    /**
     * 隐藏SSL、公开SSL（验证SSL）、公开SSL（验证TLS）（可配置config）
     * 
     * @param protocol
     * @param trustmgr
     * @param server
     * @param port
     * @param user
     * @param password
     * @param ftpProperties
     * @return
     * @throws Exception
     */
    public FTPClient getFTPSClient(String protocol, String trustmgr, String server, int port, String user, String password, FtpPropertiesEntity ftpProperties) throws Exception {
        FTPSClient ftps;
        if (protocol.equals("true")) {
            ftps = new FTPSClient(true); // 隐藏SSL
        } else if (protocol.equals("false")) {
            ftps = new FTPSClient(false); // 公开SSL
        } else {
            String prot[] = protocol.split(",");
            if (prot.length == 1) { // Just protocol
                ftps = new FTPSClient(protocol);
            } else { // protocol,true|false
                ftps = new FTPSClient(prot[0], Boolean.parseBoolean(prot[1]));
            }
        }

        if ("all".equals(trustmgr)) {
            ftps.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
        } else if ("valid".equals(trustmgr)) {
            ftps.setTrustManager(TrustManagerUtils.getValidateServerCertificateTrustManager());
        } else if ("none".equals(trustmgr)) {
            ftps.setTrustManager(null);
        }

        setOtherProp(ftps, ftpProperties);
        ftps.configure(ftpProperties.getConfig());
        return ftps;
    }

    /**
     * 连接并登陆FTP服务器
     * 
     * @param ftpClinent
     * @param server
     * @param port
     * @param user
     * @param password
     * @param ftpProperties
     * @return
     * @throws Exception
     */
    public boolean connect(FTPClient ftpClinent, String server, int port, String user, String password) throws Exception {
        return connect(ftpClinent, server, port, user, password, new FtpPropertiesEntity());
    }

    /**
     * 连接并登陆FTP服务器（可配置config）
     * 
     * @param ftpClinent
     * @param server
     * @param port
     * @param user
     * @param password
     * @param ftpProperties
     * @return
     * @throws Exception
     */
    public boolean connect(FTPClient ftpClinent, String server, int port, String user, String password, FtpPropertiesEntity ftpProperties) throws Exception {
        boolean success = false;
        try {
            ftpClinent.connect(server, port);// 连接FTP服务器

            if (!ftpClinent.login(user, password)) { // 登陆FTP服务器
                this.disconnect(ftpClinent);
                return false;
            }

            logger.info("连接到 " + server + " on " + (port > 0 ? port : ftpClinent.getDefaultPort()));

            // After connection attempt, you should check the reply code to verify success.
            int reply = ftpClinent.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                logger.info("未连接到FTP,用户名或密码错误!");
                this.disconnect(ftpClinent);
                success = false;
            } else {
                logger.info("FTP连接成功!");
                success = true;

                if (ftpProperties.isBinaryTransfer())
                    ftpClinent.setFileType(FTP.BINARY_FILE_TYPE);
                else
                    ftpClinent.setFileType(FTP.ASCII_FILE_TYPE);

                if (ftpProperties.isLocalActive())
                    ftpClinent.enterLocalActiveMode(); // 主动模式
                else
                    ftpClinent.enterLocalPassiveMode(); // 被动模式

                if (ftpProperties.isUseEpsvWithIPv4())
                    ftpClinent.setUseEPSVwithIPv4(ftpProperties.isUseEpsvWithIPv4());
            }
        } catch (SocketException e) {
            success = false;
            e.printStackTrace();
            logger.info("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            success = false;
            e.printStackTrace();
            logger.info("FTP的端口错误,请正确配置。");
        }

        return success;
    }

    /**
     * 
     * @param ftpClinent
     * @throws IOException
     */
    public void disconnect(FTPClient ftpClinent) throws IOException {
        if (ftpClinent.isConnected()) {
            try {
                ftpClinent.logout();
                ftpClinent.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("ftp 关闭失败.");
            }
        }
    }

    /**
     * 
     * @param absSrcFileName
     * @param destDir
     * @param destFileName
     * @param ftpClient
     * @throws IOException
     */
    public void upLoadByFtp(String absSrcFileName, String destDir, String destFileName, FTPClient ftpClient) throws IOException {
        // 创建并转到工作目录
        String absDstDir = ftpClient.printWorkingDirectory() + "/" + destDir;
        absDstDir = absDstDir.replaceAll("//", "/");
        createDirectory(absDstDir, ftpClient);
        ftpClient.setBufferSize(1024);

        // 进度监听
        File srcFile = new File(absSrcFileName);
        ftpClient.setCopyStreamListener(new FtpCopyStreamListener(srcFile.length()));
        FTPFile[] files = ftpClient.listFiles(destFileName);
        if (files.length == 1) {// 断点续传
            long dstFileSize = files[0].getSize();
            if (srcFile.length() <= dstFileSize) {// 文件已存在
                return;
            }
            boolean b = uploadFile(destFileName, srcFile, dstFileSize, ftpClient);
            if (!b) {// 如果断点续传没有成功，则删除服务器上文件，重新上传
                if (ftpClient.deleteFile(destFileName)) {
                    uploadFile(destFileName, srcFile, 0, ftpClient);
                } else {
                    logger.error("Delete file fail.");
                }
            }
        } else {
            uploadFile(destFileName, srcFile, 0, ftpClient);
        }
    }

    /**
     * 
     * @param remoteFileName
     * @param localFileName
     * @param ftpClient
     * @throws IOException
     */
    public void downLoadByFtp(String remoteFileName, String localFileName, FTPClient ftpClient) throws IOException {
        InputStream input = null;
        FileOutputStream fos = null;
        // 设置各种属性
        ftpClient.setBufferSize(1024);
        ftpClient.setDataTimeout(1000 * 10);

        // 判断远程文件是否存在
        FTPFile[] files = ftpClient.listFiles(remoteFileName);
        if (files.length != 1) {
            logger.error("Remote file not exist.<" + remoteFileName + ">");
            return;
        }
        // 进度监听
        long remoteSize = files[0].getSize();
        ftpClient.setCopyStreamListener(new FtpCopyStreamListener(remoteSize));
        File file = new File(localFileName);
        if (file.exists()) {
            long localSize = file.length();
            if (localSize >= remoteSize) {
                return;
            }
            logger.info("@@@Break point download.@@@");
            fos = new FileOutputStream(file, true);// append模式
            ftpClient.setRestartOffset(localSize);
        } else {
            fos = new FileOutputStream(file); // override模式
        }

        input = ftpClient.retrieveFileStream(remoteFileName);
        byte[] b = new byte[8192];
        int n = 0;
        while (-1 != (n = input.read(b))) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            fos.write(b, 0, n);
        }
        if (input != null) {
            input.close();
        }
        if (fos != null) {
            fos.flush();
            fos.close();
        }

        if (!ftpClient.completePendingCommand()) {
            logger.error("Download file fail.");
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }

    /**
     * 
     * @param destFileName
     * @param srcFile
     * @param dstFileSize
     * @param ftpClient
     * @return
     * @throws IOException
     */
    private boolean uploadFile(String destFileName, File srcFile, long dstFileSize, FTPClient ftpClient) throws IOException {
        RandomAccessFile input = null;
        OutputStream fout = null;

        input = new RandomAccessFile(srcFile, "r"); // 只读模式
        if (dstFileSize > 0) {// 断点续传
            fout = ftpClient.appendFileStream(destFileName);
            input.seek(dstFileSize);
            ftpClient.setRestartOffset(dstFileSize);
        } else {
            fout = ftpClient.storeFileStream(destFileName);
        }
        byte[] b = new byte[8192]; // 缓存大小
        int n = 0;
        while (-1 != (n = input.read(b))) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            fout.write(b, 0, n);
        }
        if (input != null) {
            input.close();
        }
        if (fout != null) {
            fout.flush();
            fout.close();
        }
        if (!ftpClient.completePendingCommand()) {
            System.err.println("Upload file fail.");
            ftpClient.logout();
            ftpClient.disconnect();
            return false;
        }
        return true;
    }

    /**
     * 在FTP服务器上创建并转到工作目录
     * 
     * @param relativePath 相对工作路径，不包含文件名：如 dd/11/22/33
     * @param ftpClient 录创建是否成功
     * @return
     * @throws IOException
     */
    private boolean createDirectory(String relativePath, FTPClient ftpClient) throws IOException {
        if (!relativePath.startsWith("/")) {
            relativePath = "/" + relativePath;
        }
        String dir = (ftpClient.printWorkingDirectory().equals("/") ? "" : ftpClient.printWorkingDirectory()) + relativePath;
        if (!ftpClient.changeWorkingDirectory(dir)) {
            // 目录不存在，则创建各级目录
            for (String subDir : relativePath.split("/")) {
                if (!subDir.equals("")) {
                    String newDir = ftpClient.printWorkingDirectory() + "/" + subDir;
                    ftpClient.mkd(newDir);
                    if (!ftpClient.changeWorkingDirectory(newDir)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * FTP其他设置
     * 
     * @param ftp
     * @param ftpProperties
     */
    private void setOtherProp(FTPClient ftp, FtpPropertiesEntity ftpProperties) {
        // if (ftpProperties.isPrintHash())
        // ftp.setCopyStreamListener(new FtpCopyStreamListener());

        if (ftpProperties.getKeepAliveTimeout() >= 0)
            ftp.setControlKeepAliveTimeout(ftpProperties.getKeepAliveTimeout());

        if (ftpProperties.getControlKeepAliveReplyTimeout() >= 0)
            ftp.setControlKeepAliveReplyTimeout(ftpProperties.getControlKeepAliveReplyTimeout());

        if (ftpProperties.getEncoding() != null)
            ftp.setControlEncoding(ftpProperties.getEncoding());

        if (ftpProperties.isHidden())
            ftp.setListHiddenFiles(ftpProperties.isHidden());

        if (ftpProperties.isDebug())
            ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
    }
}
