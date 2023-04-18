package com.zust.austin.handler.flowcontrol.impl;

import com.google.common.util.concurrent.RateLimiter;
import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.handler.enums.RateLimitStrategy;
import com.zust.austin.handler.flowcontrol.FlowControlParam;
import com.zust.austin.handler.flowcontrol.FlowControlService;
import com.zust.austin.handler.flowcontrol.annotations.LocalRateLimit;


@LocalRateLimit(rateLimitStrategy = RateLimitStrategy.SEND_USER_NUM_RATE_LIMIT)
public class SendUserNumRateLimitServiceImpl implements FlowControlService {

    /**
     * 根据渠道进行流量控制
     *
     * @param taskInfo
     * @param flowControlParam
     */
    @Override
    public Double flowControl(TaskInfo taskInfo, FlowControlParam flowControlParam) {
        RateLimiter rateLimiter = flowControlParam.getRateLimiter();
        return rateLimiter.acquire(taskInfo.getReceiver().size());
    }
}
