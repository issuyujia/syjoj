package com.syj.syjoj.judge;

import cn.hutool.json.JSONUtil;
import com.syj.syjoj.common.ErrorCode;
import com.syj.syjoj.exception.BusinessException;
import com.syj.syjoj.judge.codesandbox.CodeSandBox;
import com.syj.syjoj.judge.codesandbox.CodeSandboxFactory;
import com.syj.syjoj.judge.codesandbox.CodeSandboxProxy;
import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.syj.syjoj.judge.strategy.DefaultJudgeStrategy;
import com.syj.syjoj.judge.strategy.JudgeContext;
import com.syj.syjoj.judge.strategy.JudgeStrategy;
import com.syj.syjoj.model.dto.question.JudgeCase;
import com.syj.syjoj.judge.codesandbox.model.JudgeInfo;
import com.syj.syjoj.model.entity.Question;
import com.syj.syjoj.model.entity.QuestionSubmit;
import com.syj.syjoj.model.enums.QuestionSubmitStatusEnum;
import com.syj.syjoj.service.QuestionService;
import com.syj.syjoj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author syj
 * @date 2024/8/1 22:15
 */
@Service
public class JudgeServiceImpl implements JudgeService {
    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private JudgeManage judgeManage;

    @Value("${codesandbox.type:example}")
    private String type;

    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        //1.传入题目的id，获取到对应的题目，提交信息（包含代码，编程语言等）
        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "提交信息不存在");
        }
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");
        }
        //2.更改题目的判题状态
        //不为等待状态
        if (!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITTING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目正在判题中");
        }
        //3.进行代码状态的更改
        QuestionSubmit qusetionSubmitUpdate = new QuestionSubmit();
        qusetionSubmitUpdate.setQuestionId(questionSubmitId);
        qusetionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUUNING.getValue());
        boolean update = questionSubmitService.updateById(qusetionSubmitUpdate);
        if (!update) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目状态更新错误");
        }
        //4.调用沙箱，获取到执行结果
        CodeSandBox codeSandBox = CodeSandboxFactory.newInstance(type);
        codeSandBox = new CodeSandboxProxy(codeSandBox);
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        //获取测试用例
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());

        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutputList();
        //5.根据沙箱的执行结果，设置题目的判题状态和信息
        //封装判题所需要的上下文信息
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setQuestion(question);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestionSubmit(questionSubmit);
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        JudgeInfo judgeInfo = judgeManage.doJudge(judgeContext);
        //判题完毕修改数据库的判题结果
        qusetionSubmitUpdate = new QuestionSubmit();
        qusetionSubmitUpdate.setQuestionId(questionSubmitId);
        qusetionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        qusetionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        update = questionSubmitService.updateById(qusetionSubmitUpdate);
        if (!update) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目状态更新错误");
        }
        QuestionSubmit qusetionSubmitResult = questionSubmitService.getById(questionId);
        return qusetionSubmitResult;
    }
}
