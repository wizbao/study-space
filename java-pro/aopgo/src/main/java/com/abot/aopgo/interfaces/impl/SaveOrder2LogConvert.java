package com.abot.aopgo.interfaces.impl;

import com.abot.aopgo.interfaces.LogConvert;
import com.abot.aopgo.logger.OperateLogDO;
import com.abot.aopgo.service.SaveOrder;

/**
 * @author weibao
 */
public class SaveOrder2LogConvert implements LogConvert<SaveOrder> {
    @Override
    public OperateLogDO convert(SaveOrder saveOrder) {
        OperateLogDO logDO = new OperateLogDO();
        logDO.setOrderId(saveOrder.getId());
        return logDO;
    }
}
