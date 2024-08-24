package com.syj.syjojbackendjudgeservice.judge.codesandbox.impl;

import com.syj.syjojbackendjudgeservice.judge.codesandbox.CodeSandBox;
import com.syj.syjojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.syj.syjojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.syj.syjojbackendmodel.model.codesandbox.JudgeInfo;
import com.syj.syjojbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.syj.syjojbackendmodel.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * @author syj
 * @date 2024/7/30 22:03
 */

/**
 * 实例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        executeCodeResponse.setOutputList(inputList);
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
