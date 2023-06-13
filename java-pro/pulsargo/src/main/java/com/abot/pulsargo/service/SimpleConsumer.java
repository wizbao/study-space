package com.abot.pulsargo.service;

import org.apache.pulsar.client.api.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author weibao
 */
@Component
public class SimpleConsumer {
    @Resource
    private PulsarClient client;

    public void consumeMsg() throws PulsarClientException {
        // 使用客户端创建消费者
        Consumer consumer = client.newConsumer()
                .topic("my-topic")
                .subscriptionName("my-subscription")
                .subscribe();
        Message msg = consumer.receive();
        System.out.println("==========================="+new String(msg.getData()));
    }
}


