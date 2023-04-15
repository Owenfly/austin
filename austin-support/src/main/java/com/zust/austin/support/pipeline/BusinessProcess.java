package com.zust.austin.support.pipeline;


/**
 * @author wlp
 * @description 业务执行器
 */
public interface BusinessProcess<T extends ProcessModel> {

    void process(ProcessContext<T> context);

}