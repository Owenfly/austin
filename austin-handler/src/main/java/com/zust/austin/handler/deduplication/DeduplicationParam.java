package com.zust.austin.handler.deduplication;

import com.alibaba.fastjson.annotation.JSONField;
import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.common.enums.AnchorState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 去重参数类型
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeduplicationParam {

    private TaskInfo taskInfo;

    /**
     * 去重时间
     * 单位：秒
     */
    @JSONField(name = "time")
    private Long deduplicationTime;

    /**
     * 去重次数
     */
    @JSONField(name = "num")
    private Integer countNum;

    /**
     * 标识去重类型
     */
    private AnchorState anchorState;
}
