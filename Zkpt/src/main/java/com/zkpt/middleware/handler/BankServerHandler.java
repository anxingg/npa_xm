package com.zkpt.middleware.handler;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.middleware.service.IMwTransportService;
import com.zkpt.rabbitmq.RabbitMqConfig;

/*
 * 服务器逻辑控制类
 * 
 */
@Component
public class BankServerHandler extends IoHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(BankServerHandler.class);

    private static Map<String, IoSession> sessions_ip = new HashMap<String, IoSession>(); // 控制某个IP的连接
    private static int sessionSize = 0; // 控制连接总量
    private static int maxSessionSize = 100;

    @Autowired
    private IMwTransportService mwTransportService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 连接创建
     */
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) session.getRemoteAddress();
        InetAddress address = inetSocketAddress.getAddress();
        String ip = address.getHostAddress();
        int port = inetSocketAddress.getPort();
        logger.info("中间件服务会话创建，连接过来的银行客户端IP和端口为:" + ip + ":" + port);
    }

    /**
     * 连接打开
     */
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        if (sessionSize > maxSessionSize) {
            logger.info("客户端超出最大数量！");
            session.closeOnFlush();
            return;
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) session.getRemoteAddress();
        InetAddress address = inetSocketAddress.getAddress();
        String ip = address.getHostAddress();
        int port = inetSocketAddress.getPort();
        if (null != sessions_ip.get(ip)) {
            logger.info("该IP已有客户端连接，禁止新链接");
            session.closeOnFlush();
            return;
        }
        sessions_ip.put(ip, session);
        sessionSize++;

        logger.info("中间件服务器会话打开，连接过来的银行客户端IP和端口为:" + ip + ":" + port);
    }

    /**
     * 接收消息
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        BankProtocalPackage protocalPackage = (BankProtocalPackage) message;
        //rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, protocalPackage.toString());
        logger.info("中间件服务器收到" + session.getRemoteAddress() + "数据包:\n" + protocalPackage);
        mwTransportService.trans_in(protocalPackage);
    }

    /**
     * 发送消息
     */
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        BankProtocalPackage protocalPackage = (BankProtocalPackage) message;
        //rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, protocalPackage.toString());
        logger.info("中间件服务器给" + session.getRemoteAddress() + "发送数据包:\n" + protocalPackage);
        super.messageSent(session, message);
        session.closeOnFlush();
    }

    /**
     * 连接关闭
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) session.getRemoteAddress();
        InetAddress address = inetSocketAddress.getAddress();
        String ip = address.getHostAddress();
        int port = inetSocketAddress.getPort();
        // 这里是有这个IP才能移除且总数减一，如果你不想以IP来控制，只是要控制总数，那么在客户端来的时候就要以(IP+端口)为依据来缓存该客户端，然后做出减一操作
        if (null != sessions_ip.get(ip)) {
            logger.info("客户端离开：" + ip + "：" + port);
            sessions_ip.remove(ip);
            sessionSize--;
        }

        logger.info("连接到中间件服务器客户端离开：" + ip + "：" + port + " ......");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
        session.closeOnFlush();
    }
}
