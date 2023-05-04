package com.zust.austin.handler.shield.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zust.austin.common.domain.AnchorInfo;
import com.zust.austin.common.domain.TaskInfo;
import com.zust.austin.common.enums.AnchorState;
import com.zust.austin.common.enums.ShieldType;
import com.zust.austin.handler.shield.ShieldService;
import com.zust.austin.support.utils.LogUtils;
import com.zust.austin.support.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * 屏蔽服务
 *
 * @author wlp
 */
@Service
@Slf4j
public class ShieldServiceImpl implements ShieldService {

    //设置夜晚屏蔽，第二天执行
    private static final String NIGHT_SHIELD_BUT_NEXT_DAY_SEND_KEY = "night_shield_send";

    private static final long SECONDS_OF_A_DAY = 86400L;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private LogUtils logUtils;

    @Override
    public void shield(TaskInfo taskInfo) {

        //夜间不屏蔽
        if (ShieldType.NIGHT_NO_SHIELD.getCode().equals(taskInfo.getShieldType())) {
            return;
        }

        /**
         * 实现夜间屏蔽，隔日送达
         */
        if (isNight()) {
            if (ShieldType.NIGHT_SHIELD.getCode().equals(taskInfo.getShieldType())) {
                logUtils.print(AnchorInfo.builder()
                        .state(AnchorState.NIGHT_SHIELD.getCode())
                        .businessId(taskInfo.getBusinessId())
                        .ids(taskInfo.getReceiver()).build());
            }
            if (ShieldType.NIGHT_SHIELD_BUT_NEXT_DAY_SEND.getCode().equals(taskInfo.getShieldType())) {
                redisUtils.lPush(
                        NIGHT_SHIELD_BUT_NEXT_DAY_SEND_KEY,
                        JSON.toJSONString(taskInfo, SerializerFeature.WriteClassName),
                        SECONDS_OF_A_DAY);

                logUtils.print(AnchorInfo.builder()
                        .state(AnchorState.NIGHT_SHIELD_NEXT_SEND.getCode())
                        .businessId(taskInfo.getBusinessId())
                        .ids(taskInfo.getReceiver()).build());
            }
            taskInfo.setReceiver(new HashSet<>());
        }

    }

    /**
     * 小时 < 8 默认就认为是凌晨(夜晚)
     *
     * @return
     */
    private boolean isNight() {
        return LocalDateTime.now().getHour() < 8;
    }

}
