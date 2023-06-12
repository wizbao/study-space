package com.abot.transactiongo;

import com.abot.transactiongo.controller.PaymentController;
import com.abot.transactiongo.service.impl.ActorServiceImpl;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

@SpringBootTest
class TransactiongoApplicationTests {

    @Resource
    private ActorServiceImpl actorService;

    @Resource
    private PaymentController paymentController;

    @Test
    void contextLoads() throws FileNotFoundException {
//        actorService.testTransactional();
        actorService.foo();
    }

    @Test
    void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            paymentController.updateAmount();
        });
        Thread t2 = new Thread(() -> {
            paymentController.updateAmount();
        });
        t1.start();
        t2.start();
        Thread.sleep(3000);
    }

    @Test
    void test2(){
        paymentController.updateAmount();
    }

}
