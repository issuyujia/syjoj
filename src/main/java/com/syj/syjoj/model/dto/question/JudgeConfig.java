package com.syj.syjoj.model.dto.question;

/**
 * @author syj
 * @date 2024/7/22 22:21
 */

import lombok.Data;

/**
 * 题目用例
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制（ms）
     */
    private Long timeLimit;
    /**
     * 内存限制(KB)
     */
    private Long memoryLimit;
    /**
     * 堆栈限制(KB)
     */
    private Long stackLimit;
}
