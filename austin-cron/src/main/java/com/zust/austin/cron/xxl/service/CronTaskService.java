package com.zust.austin.cron.xxl.service;

import com.zust.austin.common.vo.BasicResultVO;
import com.zust.austin.cron.xxl.entity.XxlJobGroup;
import com.zust.austin.cron.xxl.entity.XxlJobInfo;

/**
 * 定时任务服务
 *
 */
public interface CronTaskService {


    BasicResultVO saveCronTask(XxlJobInfo xxlJobInfo);

    BasicResultVO deleteCronTask(Integer taskId);

    BasicResultVO startCronTask(Integer taskId);

    BasicResultVO stopCronTask(Integer taskId);

    BasicResultVO getGroupId(String appName, String title);

    BasicResultVO createGroup(XxlJobGroup xxlJobGroup);

}
