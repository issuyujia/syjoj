package com.syj.syjojbackendmodel.model.codesandbox;

import lombok.Data;

/**
 * @author syj
 * @date 2024/7/22 22:31
 */
@Data
public class JudgeInfo {
    /**
     * 程序执行时间
     */
    private String message;
    /**
     * 消耗内存
     */
    private Long memory;
    /**
     * 消耗时间（KB）
     */
    private Long time;
}
