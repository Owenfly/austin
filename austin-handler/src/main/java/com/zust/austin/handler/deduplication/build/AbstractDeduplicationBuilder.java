package com.zust.austin.handler.deduplication.build;

import com.alibaba.fastjson.JSONObject;
import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.handler.deduplication.DeduplicationHolder;
import com.zust.austin.handler.deduplication.DeduplicationParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @author 3y
 * @date 2022/1/19
 */
public abstract class AbstractDeduplicationBuilder implements Builder {

    protected Integer deduplicationType;

    @Autowired
    private DeduplicationHolder deduplicationHolder;

    @PostConstruct
    public void init() {
        deduplicationHolder.putBuilder(deduplicationType, this);
    }

    public DeduplicationParam getParamsFromConfig(Integer key, String duplicationConfig, TaskInfo taskInfo) {
        JSONObject object = JSONObject.parseObject(duplicationConfig);
        if (Objects.isNull(object)) {
            return null;
        }
        DeduplicationParam deduplicationParam = JSONObject.parseObject(object.getString(DEDUPLICATION_CONFIG_PRE + key), DeduplicationParam.class);
        if (Objects.isNull(deduplicationParam)) {
            return null;
        }
        deduplicationParam.setTaskInfo(taskInfo);
        return deduplicationParam;
    }

}
