package com.zust.austin.service.api.impl.config;


import com.zust.austin.service.api.enums.BusinessCode;
import com.zust.austin.service.api.impl.action.AfterParamCheckAction;
import com.zust.austin.service.api.impl.action.AssembleAction;
import com.zust.austin.service.api.impl.action.PreParamCheckAction;
import com.zust.austin.service.api.impl.action.SendMqAction;
import com.zust.austin.support.pipeline.BusinessProcess;
import com.zust.austin.support.pipeline.ProcessController;
import com.zust.austin.support.pipeline.ProcessTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * api层的pipeline配置类
 *
 */
@Configuration
public class PipelineConfig {

    @Autowired
    private PreParamCheckAction preParamCheckAction;
    @Autowired
    private AssembleAction assembleAction;
    @Autowired
    private AfterParamCheckAction afterParamCheckAction;
    @Autowired
    private SendMqAction sendMqAction;

    /**
     * 普通发送执行流程
     * 1. 前置参数校验
     * 2. 组装参数
     * 3. 后置参数校验
     * 4. 发送消息至MQ
     *
     * @return
     */
    @Bean("commonSendTemplate")
    public ProcessTemplate commonSendTemplate() {

        ProcessTemplate processTemplate = new ProcessTemplate();
        processTemplate.setProcessList(Arrays.asList(preParamCheckAction, assembleAction,
                afterParamCheckAction, sendMqAction));

        //ProcessTemplate processTemplate = new ProcessTemplate();
        //ArrayList<BusinessProcess> processList = new ArrayList<>();
        //
        //processList.add(preParamCheckAction);
        //processList.add(assembleAction);
        //processList.add(afterParamCheckAction);
        //processList.add(sendMqAction);

        //processTemplate.setProcessList(processList);

        return processTemplate;

    }

    /**
     * 消息撤回执行流程
     * 1.组装参数
     * 2.发送MQ
     *
     * @return
     */
    @Bean("recallMessageTemplate")
    public ProcessTemplate recallMessageTemplate() {
        ProcessTemplate processTemplate = new ProcessTemplate();
        processTemplate.setProcessList(Arrays.asList(assembleAction, sendMqAction));

        //ProcessTemplate processTemplate = new ProcessTemplate();
        //ArrayList<BusinessProcess> processList = new ArrayList<>();
        //processList.add(assembleAction);
        //processList.add(sendMqAction);
        //
        //processTemplate.setProcessList(processList);

        return processTemplate;
    }

    /**
     * pipeline流程控制器
     * 后续扩展则加BusinessCode和ProcessTemplate
     *
     * @return
     */
    @Bean
    public ProcessController processController() {
        ProcessController processController = new ProcessController();
        Map<String, ProcessTemplate> templateConfig = new HashMap<>(4);
        templateConfig.put(BusinessCode.COMMON_SEND.getCode(), commonSendTemplate());
        templateConfig.put(BusinessCode.RECALL.getCode(), recallMessageTemplate());
        processController.setTemplateConfig(templateConfig);
        return processController;
    }

}
