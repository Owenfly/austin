package com.zust.austin.handler.deduplication.build;

import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.handler.deduplication.DeduplicationParam;

/**
 * @author wlp
 * 构建去重参数
 */
public interface Builder {

    String DEDUPLICATION_CONFIG_PRE = "deduplication_";

    DeduplicationParam build(String deduplication, TaskInfo taskInfo);

}
