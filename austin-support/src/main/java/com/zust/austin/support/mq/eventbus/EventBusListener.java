package com.zust.austin.support.mq.eventbus;


import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.support.domain.MessageTemplate;

import java.util.List;

/**
 *
 * 监听器
 */
public interface EventBusListener {


    /**
     * 消费消息
     *
     * @param lists
     */
    void consume(List<TaskInfo> lists);

    /**
     * 撤回消息
     *
     * @param messageTemplate
     */
    void recall(MessageTemplate messageTemplate);
}
