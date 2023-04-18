package com.zust.austin.handler.deduplication.service;


import com.zust.austin.handler.deduplication.DeduplicationParam;


public interface DeduplicationService {

    /**
     * 去重
     *
     * @param param
     */
    void deduplication(DeduplicationParam param);
}
