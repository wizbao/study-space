package com.abot.transactiongo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName payment
 */
@TableName(value ="payment")
@Data
public class Payment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer paymentId;

    /**
     * 
     */
    private Integer customerId;

    /**
     * 
     */
    private Integer staffId;

    /**
     * 
     */
    private Integer rentalId;

    /**
     * 
     */
    private BigDecimal amount;

    /**
     * 
     */
    private Date paymentDate;

    /**
     * 
     */
    private Date lastUpdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}