package com.abot.transactiongo.controller;

import com.abot.transactiongo.entity.Payment;
import com.abot.transactiongo.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author weibao
 */
@Controller
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Transactional
    public void updateAmount(){
        double amount = Optional.ofNullable(paymentService.getById(1)).map(Payment::getAmount).map(BigDecimal::doubleValue).orElse(0D);
        if (amount > 0) {
            System.out.println("updateAmount");
            Payment payment = new Payment();
            payment.setPaymentId(1);
            payment.setAmount(new BigDecimal(amount+100));
            paymentService.updateById(payment);
        }
    }

}
