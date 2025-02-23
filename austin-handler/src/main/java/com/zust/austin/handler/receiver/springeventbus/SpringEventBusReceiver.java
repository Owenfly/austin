package com.zust.austin.handler.receiver.springeventbus;

import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.handler.receiver.service.ConsumeService;
import com.zust.austin.support.constans.MessageQueuePipeline;
import com.zust.austin.support.domain.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@ConditionalOnProperty(name = "austin.mq.pipeline", havingValue = MessageQueuePipeline.SPRING_EVENT_BUS)
public class SpringEventBusReceiver {

    @Autowired
    private ConsumeService consumeService;

    public void consume(List<TaskInfo> lists) {
        consumeService.consume2Send(lists);
    }

    public void recall(MessageTemplate messageTemplate) {
        consumeService.consume2recall(messageTemplate);
    }
}
