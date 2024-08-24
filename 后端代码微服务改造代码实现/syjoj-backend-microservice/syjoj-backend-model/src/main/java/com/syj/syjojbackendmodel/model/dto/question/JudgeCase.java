package com.syj.syjojbackendmodel.model.dto.question;

/**
 * @author syj
 * @date 2024/7/22 22:21
 */

import lombok.Data;

/**
 * 题目用例
 */
@Data
public class JudgeCase {
    /**
     * 输入用例
     */
    private String input;
    /**
     * 输出用例
     */
    private String output;

}
