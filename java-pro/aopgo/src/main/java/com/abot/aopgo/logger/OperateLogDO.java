package com.abot.aopgo.logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weibao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLogDO {
    private Long orderId;
    private String desc;
    private String result;
}
