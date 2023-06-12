package com.abot.transactiongo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author weibao
 */
@Component
@Aspect
@Slf4j
//@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class LogAspect {

    @Around("execution(* com.abot.transactiongo.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        log.info("执行方法start");
        Object result = null;
        try {
             result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("{}",e.getMessage(),e);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new RuntimeException(e);
        }
        log.info("执行方法end");
        return result;
    }
}
