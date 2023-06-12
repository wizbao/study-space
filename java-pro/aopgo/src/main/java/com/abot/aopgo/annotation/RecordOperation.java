package com.abot.aopgo.annotation;

import com.abot.aopgo.interfaces.LogConvert;

import java.lang.annotation.*;

/**
 * @author weibao
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RecordOperation {
    String desc() default "";
    Class<? extends LogConvert> classType();
}
