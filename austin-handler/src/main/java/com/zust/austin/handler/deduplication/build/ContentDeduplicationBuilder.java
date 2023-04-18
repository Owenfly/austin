package com.zust.austin.handler.deduplication.build;

import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.common.enums.AnchorState;
import com.zust.austin.common.enums.DeduplicationType;
import com.zust.austin.handler.deduplication.DeduplicationParam;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 消息内容去重参数
 */
@Service
public class ContentDeduplicationBuilder extends AbstractDeduplicationBuilder implements Builder {

    public ContentDeduplicationBuilder() {
        deduplicationType = DeduplicationType.CONTENT.getCode();
    }

    @Override
    public DeduplicationParam build(String deduplication, TaskInfo taskInfo) {
        DeduplicationParam deduplicationParam = getParamsFromConfig(deduplicationType, deduplication, taskInfo);
        if (Objects.isNull(deduplicationParam)) {
            return null;
        }
        deduplicationParam.setAnchorState(AnchorState.CONTENT_DEDUPLICATION);
        return deduplicationParam;

    }
}
