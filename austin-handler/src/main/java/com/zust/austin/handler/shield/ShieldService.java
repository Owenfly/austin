package com.zust.austin.handler.shield;

import com.zust.austin.common.domain.TaskInfo;

/**
 * 屏蔽服务
 *
 * @author wlp
 */
public interface ShieldService {


    /**
     * 屏蔽消息
     *
     * @param taskInfo
     */
    void shield(TaskInfo taskInfo);
}
