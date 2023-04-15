package com.zust.austin.handler.handler;

import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.support.domain.MessageTemplate;

/**
 * @author 3y
 * 消息处理器
 */
public interface Handler {

    /**
     * 处理器
     *
     * @param taskInfo
     */
    void doHandler(TaskInfo taskInfo);

    /**
     * 撤回消息
     *
     * @param messageTemplate
     * @return
     */
    void recall(MessageTemplate messageTemplate);

}
