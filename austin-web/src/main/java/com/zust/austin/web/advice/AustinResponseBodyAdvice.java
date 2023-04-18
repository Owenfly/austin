package com.zust.austin.web.advice;

import com.zust.austin.common.vo.BasicResultVO;
import com.zust.austin.web.annotation.AustinResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;


@ControllerAdvice(basePackages = "com.java3y.austin.web.controller")
public class AustinResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final String RETURN_CLASS = "BasicResultVO";

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return methodParameter.getContainingClass().isAnnotationPresent(AustinResult.class) || methodParameter.hasMethodAnnotation(AustinResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (Objects.nonNull(data) && Objects.nonNull(data.getClass())) {
            String simpleName = data.getClass().getSimpleName();
            if (RETURN_CLASS.equalsIgnoreCase(simpleName)) {
                return data;
            }
        }
        return BasicResultVO.success(data);
    }
}
