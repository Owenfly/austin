package com.zust.austin.common.domain;

import com.zust.austin.common.enums.AnchorState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * 埋点信息
 *
 * @author wlp
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnchorInfo {

    /**
     * 发送用户
     */
    private Set<String> ids;

    /**
     * 具体点位
     *
     * @see AnchorState
     */
    private int state;

    /**
     * 业务Id(数据追踪使用)
     */
    private Long businessId;


    /**
     * 日志生成时间
     */
    private long logTimestamp;

}
