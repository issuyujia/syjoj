package com.syj.syjojbackendjudgeservice.judge;


import com.syj.syjojbackendmodel.model.entity.QuestionSubmit;

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
