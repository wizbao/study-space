package com.abot.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CommonServiceApplication.class, args);
    }

    @Value("${info.name}")
    private String infoName;
    @Value("${diff}")
    private String diff;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("infoName = " + infoName);
        System.out.println("diff = " + diff);

    }
}
