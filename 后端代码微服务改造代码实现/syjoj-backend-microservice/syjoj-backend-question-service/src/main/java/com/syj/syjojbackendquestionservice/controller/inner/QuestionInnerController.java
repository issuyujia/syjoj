package com.syj.syjojbackendquestionservice.controller.inner;

/**
 * @author syj
 * @date 2024/8/19 20:35
 */

import com.syj.syjojbackendmodel.model.entity.Question;
import com.syj.syjojbackendmodel.model.entity.QuestionSubmit;
import com.syj.syjojbackendquestionservice.service.QuestionService;
import com.syj.syjojbackendquestionservice.service.QuestionSubmitService;
import com.syj.syjojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 注意：改服务仅内部调用，外部无法调用
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {
    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(@RequestParam("questionId") long questionId) {
        return questionService.getById(questionId);
    }

    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionId") long questionSubmitId) {
        return questionSubmitService.getById(questionSubmitId);
    }

    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit) {
        return questionSubmitService.updateById(questionSubmit);
    }
}
