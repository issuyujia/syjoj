package com.syj.syjoj.judge;

import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.syj.syjoj.model.entity.QuestionSubmit;
import com.syj.syjoj.model.vo.QuestionSubmitVO;

/**
 * @author syj
 * @date 2024/8/1 22:10
 */
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
