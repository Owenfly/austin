package com.zust.austin.common.constant;


/**
 * Austin常量信息
 *
 * @author wlp
 */
public class AustinConstant {

    /**
     * businessId默认的长度
     *  generate logic : TaskInfoUtils
     */
    public final static Integer BUSINESS_ID_LENGTH = 16;

    /**
     * 接口限制 最多的人数
     */
    public static final Integer BATCH_RECEIVER_SIZE = 100;

    /**
     * 消息发送给全部人的标识
     * (企业微信 应用消息)
     * (钉钉自定义机器人)
     * (钉钉工作消息)
     */
    public static final String SEND_ALL = "@all";


    /**
     * 默认的常量，如果新建模板/账号时，没传入则用该常量
     */
    public static final String DEFAULT_CREATOR = "wlp";
    public static final String DEFAULT_UPDATOR = "wlp";
    public static final String DEFAULT_TEAM = "wlp的公众号";
    public static final String DEFAULT_AUDITOR = "wlp";


}
