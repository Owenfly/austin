package com.zust.austin.support.exception;

import com.zust.austin.common.enums.RespStatusEnum;
import com.zust.austin.support.pipeline.ProcessContext;

import java.util.Objects;

/**
 * @author wlp
 * @description 异常信息处理
 */
public class ProcessException extends RuntimeException {

    /**
     * 流程处理上下文
     */
    private final ProcessContext processContext;

    public ProcessException(ProcessContext processContext) {
        super();
        this.processContext = processContext;
    }

    public ProcessException(ProcessContext processContext, Throwable cause) {
        super(cause);
        this.processContext = processContext;
    }

    @Override
    public String getMessage() {
        if (Objects.nonNull(this.processContext)) {
            return this.processContext.getResponse().getMsg();
        }
        return RespStatusEnum.CONTEXT_IS_NULL.getMsg();

    }

    public ProcessContext getProcessContext() {
        return processContext;
    }
}
