package com.abot.aopgo;

import com.abot.aopgo.service.OrderService;
import com.abot.aopgo.service.SaveOrder;
import com.abot.aopgo.service.UploadOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class AopgoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AopgoApplication.class, args);
    }

    @Resource
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        orderService.saveOrder(new SaveOrder(1L));
        orderService.uploadOrder(new UploadOrder(2L));
    }
}
