package com.zkpt.middleware.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.gas.entity.GasProtocalPackage;
import com.zkpt.middleware.service.IMwTransportService;
import com.zkpt.rabbitmq.RabbitMqConfig;

/**
 * 
 * @author zhaoqi
 *
 */
@Component
public class GasClientHandler extends IoHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(GasClientHandler.class);

    @Autowired
    private IMwTransportService mwTransportService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 连接创建
     */
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        logger.info("中间件服务器创建天然气客户端，IP和端口为: " + session.getRemoteAddress());
    }

    /**
     * 连接打开
     */
    public void sessionOpened(IoSession session) throws Exception {
        logger.info("中间件服务器创建天然气客户端会话打开，IP和端口为: " + session.getRemoteAddress());
    }

    /**
     * 接收消息
     */
    public void messageReceived(IoSession session, Object message) throws Exception {
        GasProtocalPackage protocalPackage = (GasProtocalPackage) message;
        logger.info("中间件服务器创建天然气客户端收到的消息:\n" + protocalPackage);
        BankProtocalPackage serverSessionKey = (BankProtocalPackage) session.getAttribute("serverSessionKey");
        //rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, protocalPackage.toString());
        mwTransportService.trans_out(protocalPackage, serverSessionKey);
        session.removeAttribute("serverSessionKey");
        session.closeOnFlush();
    }

    /**
     * 发送消息
     */
    public void messageSent(IoSession session, Object message) throws Exception {
        GasProtocalPackage protocalPackage = (GasProtocalPackage) message;
        logger.info("中间件服务器创建天然气客户端发送消息:\n" + protocalPackage);
        //rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, protocalPackage.toString());
        super.messageSent(session, message);
    }

    /**
     * 会话关闭
     */
    public void sessionClosed(IoSession session) throws Exception {
        logger.info(session.getRemoteAddress() + "连接到天然气服务器关闭......");
        super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info("-客户端与服务端连接[空闲] - " + status.toString());
    }
}
