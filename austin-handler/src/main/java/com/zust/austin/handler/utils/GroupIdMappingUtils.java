package com.zust.austin.handler.utils;

import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.common.enums.ChannelType;
import com.zust.austin.common.enums.EnumUtil;
import com.zust.austin.common.enums.MessageType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wlp
 * @description 获取消费者ID
 */
public class GroupIdMappingUtils {

    /**
     * 获取所有的groupIds
     * @return
     */
    public static List<String> getAllGroupIds() {
        List<String> groupIds = new ArrayList<>();
        for (ChannelType channelType : ChannelType.values()) {
            for (MessageType messageType : MessageType.values()) {
                groupIds.add(channelType.getCodeEn() + "." + messageType.getCodeEn());
            }
        }
        return groupIds;
    }


    public static String getGroupIdByTaskInfo(TaskInfo taskInfo) {
        String channelCodeEn = EnumUtil.getEnumByCode(taskInfo.getSendChannel(), ChannelType.class).getCodeEn();
        String msgCodeEn = EnumUtil.getEnumByCode(taskInfo.getMsgType(), MessageType.class).getCodeEn();
        return channelCodeEn + "." + msgCodeEn;
    }
}
