package com.syj.syjoj.judge.strategy;

/**
 * @author syj
 * @date 2024/8/3 15:08
 */

import com.syj.syjoj.judge.codesandbox.model.JudgeInfo;

/**
 * 判题策略接口
 */
public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
