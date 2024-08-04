package com.syj.syjoj.judge;

/**
 * @author syj
 * @date 2024/8/3 16:09
 */

import com.syj.syjoj.judge.strategy.DefaultJudgeStrategy;
import com.syj.syjoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.syj.syjoj.judge.strategy.JudgeContext;
import com.syj.syjoj.judge.strategy.JudgeStrategy;
import com.syj.syjoj.judge.codesandbox.model.JudgeInfo;
import com.syj.syjoj.model.entity.QuestionSubmit;
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
