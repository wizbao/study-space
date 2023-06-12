package com.abot.aopgo.service;

import com.abot.aopgo.annotation.RecordOperation;
import com.abot.aopgo.interfaces.impl.SaveOrder2LogConvert;
import com.abot.aopgo.interfaces.impl.UploadOrder2LogConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;

/**
 * @author weibao
 */
@Service
public class OrderService{

    @RecordOperation(desc = "保存订单",classType = SaveOrder2LogConvert.class)
    public Boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("save order,orderId: " + saveOrder.getId());
        return true;
    }

    @RecordOperation(desc = "上传订单",classType = UploadOrder2LogConvert.class)
    public Boolean uploadOrder(UploadOrder uploadOrder) {
        System.out.println("upload order,orderId: " + uploadOrder.getOrderId());
        return true;
    }
}
