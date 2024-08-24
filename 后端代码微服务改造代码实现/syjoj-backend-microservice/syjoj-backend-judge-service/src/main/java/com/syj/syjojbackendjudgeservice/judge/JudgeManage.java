package com.syj.syjojbackendjudgeservice.judge;

/**
 * @author syj
 * @date 2024/8/3 16:09
 */

import com.syj.syjojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.syj.syjojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.syj.syjojbackendjudgeservice.judge.strategy.JudgeContext;
import com.syj.syjojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.syj.syjojbackendmodel.model.codesandbox.JudgeInfo;
import com.syj.syjojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManage {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
