package com.abot.aopgo.interfaces.impl;

import com.abot.aopgo.interfaces.LogConvert;
import com.abot.aopgo.logger.OperateLogDO;
import com.abot.aopgo.service.UploadOrder;

/**
 * @author weibao
 */
public class UploadOrder2LogConvert implements LogConvert<UploadOrder> {
    @Override
    public OperateLogDO convert(UploadOrder uploadOrder) {
        OperateLogDO logDO = new OperateLogDO();
        logDO.setOrderId(uploadOrder.getOrderId());
        return logDO;
    }
}
