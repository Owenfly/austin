package com.zust.austin.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 埋点信息枚举
 *
 * @author wlp
 */
@Getter
@ToString
@AllArgsConstructor
public enum AnchorState implements PowerfulEnum {


    RECEIVE(10, "消息接收成功"),

    DISCARD(20, "消费被丢弃"),

    NIGHT_SHIELD(22, "夜间屏蔽"),

    NIGHT_SHIELD_NEXT_SEND(24, "夜间屏蔽(次日早上9点发送)"),

    CONTENT_DEDUPLICATION(30, "消息被内容去重"),

    RULE_DEDUPLICATION(40, "消息被频次去重"),

    WHITE_LIST(50, "白名单过滤"),

    SEND_SUCCESS(60, "消息下发成功"),

    SEND_FAIL(70, "消息下发失败"),

    CLICK(64, "消息被点击"),
    ;



    private final Integer code;
    private final String description;
}
