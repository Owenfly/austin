package com.zust.austin.handler.receiver.eventbus;

import com.google.common.eventbus.Subscribe;
import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.handler.receiver.service.ConsumeService;
import com.zust.austin.support.constans.MessageQueuePipeline;
import com.zust.austin.support.domain.MessageTemplate;
import com.zust.austin.support.mq.eventbus.EventBusListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wlp
 */
@Component
@ConditionalOnProperty(name = "austin.mq.pipeline", havingValue = MessageQueuePipeline.EVENT_BUS)
public class EventBusReceiver implements EventBusListener {

    @Autowired
    private ConsumeService consumeService;

    @Override
    @Subscribe
    public void consume(List<TaskInfo> lists) {
        consumeService.consume2Send(lists);

    }

    @Override
    @Subscribe
    public void recall(MessageTemplate messageTemplate) {
        consumeService.consume2recall(messageTemplate);
    }
}
