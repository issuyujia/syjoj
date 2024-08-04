package com.syj.syjoj.judge.strategy;

/**
 * @author syj
 * @date 2024/8/3 15:09
 */

import com.syj.syjoj.model.dto.question.JudgeCase;
import com.syj.syjoj.judge.codesandbox.model.JudgeInfo;
import com.syj.syjoj.model.entity.Question;
import com.syj.syjoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文，用于定义在策略中传递的参数
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private Question question;

    private List<JudgeCase> judgeCaseList;

    private QuestionSubmit questionSubmit;
}
