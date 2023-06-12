package com.abot.aopgo.interfaces;

import com.abot.aopgo.logger.OperateLogDO;
import com.abot.aopgo.service.OrderService;
import org.springframework.boot.CommandLineRunner;

/**
 * @author weibao
 */
public interface LogConvert<PARAM> {
    OperateLogDO convert(PARAM param);
}
