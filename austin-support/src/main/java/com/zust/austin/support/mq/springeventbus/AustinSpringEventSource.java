package com.zust.austin.support.mq.springeventbus;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AustinSpringEventSource {
    public String topic;
    public String jsonValue;
    public String tagId;
}
