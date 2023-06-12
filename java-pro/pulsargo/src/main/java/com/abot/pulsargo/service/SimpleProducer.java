package com.abot.pulsargo.service;

import jakarta.annotation.Resource;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.stereotype.Component;


/**
 * @author weibao
 */
@Component
public class SimpleProducer {
    @Resource
    private PulsarClient client;

    public void sendMsg(String msg) throws PulsarClientException {
        // 使用客户端创建生产者
        Producer<String> stringProducer = client.newProducer(Schema.STRING)
                .topic("my-topic")
                .create();
        stringProducer.send(msg);
    }
}
