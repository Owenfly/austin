package com.zust.austin.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 简单的埋点信息
 *
 * @author wlp
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleAnchorInfo {


    /**
     * 具体点位
     */
    private int state;

    /**
     * 业务Id(数据追踪使用)
     */
    private Long businessId;

    /**
     * 生成时间
     */
    private long timestamp;
}
