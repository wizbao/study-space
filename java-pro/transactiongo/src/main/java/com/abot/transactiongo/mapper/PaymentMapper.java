package com.abot.transactiongo.mapper;


import com.abot.transactiongo.entity.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【payment】的数据库操作Mapper
* @createDate 2023-06-12 10:11:05
* @Entity generator.entity.Payment
*/
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

}




