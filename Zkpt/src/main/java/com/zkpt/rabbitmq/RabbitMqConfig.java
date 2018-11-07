package com.zkpt.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Configuration
public class RabbitMqConfig {
    public final static String QUEUE_NAME = "spring-boot-queue";
    public final static String EXCHANGE_NAME = "spring-boot-exchange";
    public final static String ROUTING_KEY = "spring-boot-key";

    @Value("${spring.rabbitmq.addresses}")
    private String addresses;
    @Value("${spring.rabbitmq.port}")
    private int port;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.publisher-confirms}")
    private Boolean publisherConfirms;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    /**
     * 构建mq实例工厂
     * 
     * @return
     */
    @Bean(name = "RabbitConnectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPublisherConfirms(publisherConfirms);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    /**
     * 创建队列
     * 
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    /**
     * 创建一个 topic 类型的交换器
     * 
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * 使用路由键（routingKey）把队列（Queue）绑定到交换器（Exchange）
     * 
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        Binding c = null;
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
