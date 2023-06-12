package com.abot.transactiongo.service.impl;

import com.abot.transactiongo.entity.Payment;
import com.abot.transactiongo.mapper.PaymentMapper;
import com.abot.transactiongo.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【payment】的数据库操作Service实现
* @createDate 2023-06-12 10:11:05
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService {

}




