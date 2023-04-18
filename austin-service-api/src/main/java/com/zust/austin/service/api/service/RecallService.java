package com.zust.austin.service.api.service;

import com.zust.austin.service.api.domain.SendRequest;
import com.zust.austin.service.api.domain.SendResponse;

/**
 * 撤回接口
 *
 */
public interface RecallService {


    /**
     * 根据模板ID撤回消息
     *
     * @param sendRequest
     * @return
     */
    SendResponse recall(SendRequest sendRequest);
}
