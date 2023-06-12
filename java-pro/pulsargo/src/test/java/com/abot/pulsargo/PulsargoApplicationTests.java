package com.abot.pulsargo;

import ch.qos.logback.core.util.TimeUtil;
import com.abot.pulsargo.service.SimpleConsumer;
import com.abot.pulsargo.service.SimpleProducer;
import jakarta.annotation.Resource;
import org.apache.pulsar.client.api.PulsarClientException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PulsargoApplicationTests {

    @Resource
    private SimpleProducer producer;
    @Resource
    private SimpleConsumer consumer;


    @Test
    void contextLoads() throws PulsarClientException {
        new Thread(()->{
            try {
                consumer.consumeMsg();
            } catch (PulsarClientException e) {
                throw new RuntimeException(e);
            }
        }).start();
        producer.sendMsg("hello");
    }

}
