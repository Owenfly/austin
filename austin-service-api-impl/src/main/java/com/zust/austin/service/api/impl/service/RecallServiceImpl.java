package com.zust.austin.service.api.impl.service;

import com.zust.austin.common.vo.BasicResultVO;
import com.zust.austin.service.api.domain.SendRequest;
import com.zust.austin.service.api.domain.SendResponse;
import com.zust.austin.service.api.impl.domain.SendTaskModel;
import com.zust.austin.service.api.service.RecallService;
import com.zust.austin.support.pipeline.ProcessContext;
import com.zust.austin.support.pipeline.ProcessController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 撤回接口
 *
 */
@Service
public class RecallServiceImpl implements RecallService {

    @Autowired
    private ProcessController processController;

    @Override
    public SendResponse recall(SendRequest sendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .messageTemplateId(sendRequest.getMessageTemplateId())
                .build();
        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVO.success()).build();
        ProcessContext process = processController.process(context);
        return new SendResponse(process.getResponse().getStatus(), process.getResponse().getMsg());
    }
}
