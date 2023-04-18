package com.zust.austin.web.annotation;

import java.lang.annotation.*;

/**
 * @author wlp
 * @description 统一返回注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AustinResult {
}
