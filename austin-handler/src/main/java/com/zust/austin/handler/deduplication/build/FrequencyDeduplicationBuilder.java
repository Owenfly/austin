package com.zust.austin.handler.deduplication.build;

import cn.hutool.core.date.DateUtil;
import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.common.enums.AnchorState;
import com.zust.austin.common.enums.DeduplicationType;
import com.zust.austin.handler.deduplication.DeduplicationParam;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * 消息频次去重参数
 */
@Service
public class FrequencyDeduplicationBuilder extends AbstractDeduplicationBuilder implements Builder {

    public FrequencyDeduplicationBuilder() {
        deduplicationType = DeduplicationType.FREQUENCY.getCode();
    }

    @Override
    public DeduplicationParam build(String deduplication, TaskInfo taskInfo) {
        DeduplicationParam deduplicationParam = getParamsFromConfig(deduplicationType, deduplication, taskInfo);
        if (Objects.isNull(deduplicationParam)) {
            return null;
        }
        deduplicationParam.setDeduplicationTime((DateUtil.endOfDay(new Date()).getTime() - DateUtil.current()) / 1000);
        deduplicationParam.setAnchorState(AnchorState.RULE_DEDUPLICATION);
        return deduplicationParam;
    }
}
