package com.abot.aopgo.aop;

import com.abot.aopgo.annotation.RecordOperation;
import com.abot.aopgo.interfaces.LogConvert;
import com.abot.aopgo.interfaces.impl.SaveOrder2LogConvert;
import com.abot.aopgo.logger.OperateLogDO;
import com.abot.aopgo.service.SaveOrder;
import com.abot.aopgo.service.UploadOrder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author weibao
 */
@Component
@Aspect
@Slf4j
public class RecordAspect {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1,1,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>(100)
    );

    @Around("@annotation(anno)")
    public Object around(ProceedingJoinPoint joinPoint,RecordOperation anno) throws Throwable {
        Object result = joinPoint.proceed();
        executor.execute(()->{
            Object arg = joinPoint.getArgs()[0];
            Class<? extends LogConvert> clazz = anno.classType();
            try {
                LogConvert logConvert = clazz.newInstance();
                OperateLogDO logDO = logConvert.convert(arg);
                logDO.setDesc(anno.desc());
                logDO.setResult(result.toString());
                log.info("{}",logDO);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        return result;
    }
}
