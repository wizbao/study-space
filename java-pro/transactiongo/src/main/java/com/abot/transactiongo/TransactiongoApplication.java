package com.abot.transactiongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class TransactiongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactiongoApplication.class, args);
    }

}
