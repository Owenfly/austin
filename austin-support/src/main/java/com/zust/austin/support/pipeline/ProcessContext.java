package com.zust.austin.support.pipeline;

import com.zust.austin.common.vo.BasicResultVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 责任链上下文
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ProcessContext<T extends ProcessModel> {

    /**
     * 标识责任链的code
     */
    private String code;

    /**
     * 存储责任链上下文数据
     * 记录上文结果的载体
     */
    private T processModel;

    /**
     * 责任链中断的标识
     */
    private Boolean needBreak;

    /**
     * 流程处理的结果
     */
    BasicResultVO response;

    //private String code;
    //private T processModel;
    //private Boolean needBreak;
    //BasicResultVO response;

}
