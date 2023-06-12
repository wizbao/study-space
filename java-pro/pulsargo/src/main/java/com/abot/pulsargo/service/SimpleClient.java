package com.abot.pulsargo.service;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author weibao
 */
@Configuration
public class SimpleClient {
    @Bean
    public PulsarClient getClient() throws PulsarClientException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://43.143.173.200:6650")
                .operationTimeout(30000, TimeUnit.MILLISECONDS) //操作超时时长，默认30000ms
                .build();
        return client;
    }

}
