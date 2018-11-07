package com.zkpt.rabbitmq;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.stereotype.Service;

/**
 * 确认后回调
 * 
 * @author zhaoqi
 *
 */
//@Service("confirmCallBackListener")
public class ConfirmCallBackListener implements ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("confirm--:correlationData:" + correlationData + ",ack:" + ack + ",cause:" + cause);
    }
}
