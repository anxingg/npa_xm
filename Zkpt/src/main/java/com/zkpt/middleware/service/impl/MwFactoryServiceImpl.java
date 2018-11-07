package com.zkpt.middleware.service.impl;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.util.ReferenceCountingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.middleware.entity.MwClient;
import com.zkpt.middleware.entity.MwServer;
import com.zkpt.middleware.filter.MyIoFilter;
import com.zkpt.middleware.handler.BankServerHandler;
import com.zkpt.middleware.handler.GasClientHandler;
import com.zkpt.middleware.protocol.BankCodecFactory;
import com.zkpt.middleware.protocol.GasCodecFactory;
import com.zkpt.middleware.service.IMwFactoryService;
import com.zkpt.util.DateUtils;
import com.zkpt.util.FtpUtil;

@Service("wmFactoryService")
@Order(value = 1)
public class MwFactoryServiceImpl implements IMwFactoryService, ApplicationRunner {
    private final static Logger logger = LoggerFactory.getLogger(MwFactoryServiceImpl.class);

    @Autowired
    private Environment env;

    @Autowired
    private BankServerHandler bankServerHandler;

    @Autowired
    private GasClientHandler gasClientHandler;

    private IoAcceptor acceptor;

    @Autowired
    FtpUtil ftpUtil;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createMWServer();
    }

    /**
     * 建立服务器监听
     * 
     * @return
     * @throws IOException
     */
    @Override
    public boolean createMWServer() throws IOException {
        MwServer bankServer = new MwServer();
        // 1.初始化银行端通讯的服务器
        bankServer.setLocalAddress(env.getProperty("middleware.server.bank.ip"));
        bankServer.setPort(Integer.parseInt(env.getProperty("middleware.server.bank.port")));
        bankServer.setBufferSize(Integer.parseInt(env.getProperty("middleware.server.bank.bufferSize")));
        bankServer.setIdleTime(Integer.parseInt(env.getProperty("middleware.server.bank.idleTime")));
        bankServer.setLoggerFilterName(env.getProperty("middleware.server.bank.loggerFilterName"));
        bankServer.setReferenceCountingFilterName(env.getProperty("middleware.server.bank.referenceCountingFilterName"));
        bankServer.setProtocolCodecFilterName(env.getProperty("middleware.server.bank.protocolCodecFilterName"));
        bankServer.setCharSetName(env.getProperty("middleware.server.bank.charSetName"));

        acceptor = new NioSocketAcceptor();
        // 设置日志记录器
        // acceptor.getFilterChain().addLast(bankServer.getLoggerFilterName(), new LoggingFilter());

        // 配置Buffer大小
        acceptor.getSessionConfig().setReadBufferSize(bankServer.getBufferSize());
        // 如果Session在指定时间内没有事情做（读/写），那么就会触发Handler的sessionIdle方法
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, bankServer.getIdleTime());
        acceptor.getFilterChain().addLast(bankServer.getReferenceCountingFilterName(), new ReferenceCountingFilter(new MyIoFilter()));
        acceptor.getFilterChain().addLast(bankServer.getProtocolCodecFilterName(), new ProtocolCodecFilter(new BankCodecFactory(bankServer.getCharSetName())));
        acceptor.setHandler(bankServerHandler);
        acceptor.bind(new InetSocketAddress(bankServer.getLocalAddress(), bankServer.getPort()));

        logger.info("server : " + bankServer.getLocalAddress() + ":" + bankServer.getPort() + "开始监听!");
        return true;
    }

    @Override
    public IoSession createMWClient() throws IOException {
        MwClient mwClient = new MwClient();

        mwClient.setInetSocketAddress(env.getProperty("middleware.client.gas.ip"));
        mwClient.setPort(Integer.parseInt(env.getProperty("middleware.client.gas.port")));
        mwClient.setConnectTimeoutMillis(Integer.parseInt(env.getProperty("middleware.client.gas.connectTimeoutMillis")));
        mwClient.setReadBufferSize(Integer.parseInt(env.getProperty("middleware.client.gas.readBufferSize")));
        mwClient.setBothIdle(Integer.parseInt(env.getProperty("middleware.client.gas.both_idle")));
        mwClient.setReaderIdle(Integer.parseInt(env.getProperty("middleware.client.gas.reader_idle")));
        mwClient.setWriterIdle(Integer.parseInt(env.getProperty("middleware.client.gas.writer_idle")));
        mwClient.setLoggerFilterName(env.getProperty("middleware.client.gas.loggerFilterName"));
        mwClient.setReferenceCountingFilterName(env.getProperty("middleware.client.gas.referenceCountingFilterName"));
        mwClient.setProtocolCodecFilterName(env.getProperty("middleware.client.gas.protocolCodecFilterName"));
        mwClient.setCharSetName(env.getProperty("middleware.client.gas.charSetName"));

        IoConnector connector = new NioSocketConnector();
        IoSession session = null;

        connector.setConnectTimeoutMillis(mwClient.getConnectTimeoutMillis());
        connector.getFilterChain().addLast(mwClient.getLoggerFilterName(), new LoggingFilter());

        // 断线重连回调拦截器
        // connector.getFilterChain().addFirst("reconnection", new IoFilterAdapter() {
        // @Override
        // public void sessionClosed(NextFilter nextFilter, IoSession ioSession) throws Exception {
        // for (;;) {
        // try {
        // Thread.sleep(3000);
        // ConnectFuture future = connector.connect();
        // future.awaitUninterruptibly();// 等待连接创建成功
        // ioSession = future.getSession();// 获取会话
        // if (ioSession.isConnected()) {
        // logger.info("断线重连[" + connector.getDefaultRemoteAddress() + "]成功");
        // break;
        // }
        // } catch (Exception ex) {
        // logger.info("重连服务器登录失败,3秒再连接一次。");
        // }
        // }
        // }
        // });
        connector.getSessionConfig().setReadBufferSize(mwClient.getReadBufferSize()); // 缓冲区区的大小
        connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, mwClient.getBothIdle()); // 读写都空闲时间:30秒
        connector.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE, mwClient.getReaderIdle()); // 读(接收通道)空闲时间:40秒
        connector.getSessionConfig().setIdleTime(IdleStatus.WRITER_IDLE, mwClient.getWriterIdle()); // 写(发送通道)空闲时间:50秒
        connector.getFilterChain().addLast(mwClient.getReferenceCountingFilterName(), new ReferenceCountingFilter(new MyIoFilter()));
        connector.getFilterChain().addLast(mwClient.getProtocolCodecFilterName(), new ProtocolCodecFilter(new GasCodecFactory(mwClient.getCharSetName())));
        connector.setHandler(gasClientHandler);
        connector.setDefaultRemoteAddress(new InetSocketAddress(mwClient.getInetSocketAddress(), mwClient.getPort()));

        for (int i = 0; i < 10; i++) {
            try {
                ConnectFuture future = connector.connect();
                // 等待连接创建成功
                future.awaitUninterruptibly();
                // 获取会话
                session = future.getSession();
                logger.error("连接服务端：" + connector.getDefaultRemoteAddress() + "[成功]" + "。时间：" + DateUtils.date2Str(DateUtils.datetimeFormat));
                break;
            } catch (RuntimeIoException e) {
                logger.error("连接服务端" + connector.getDefaultRemoteAddress() + "失败" + "。时间：" + DateUtils.date2Str(DateUtils.datetimeFormat) + ", 连接MSG异常,请检查MSG端口、IP是否正确,MSG服务是否启动。",
                        e);
                try {
                    Thread.sleep(3000); // 连接失败后,重连10次,间隔3s
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
        return session;
    }

    @Override
    public IoSession getServerSession(BankProtocalPackage key) {
        return acceptor.getManagedSessions().get(key.getServerSessionKey());
    }
}
