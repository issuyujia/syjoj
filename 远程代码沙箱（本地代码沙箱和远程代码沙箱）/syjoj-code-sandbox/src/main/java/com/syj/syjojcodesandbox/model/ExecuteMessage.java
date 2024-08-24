package com.syj.syjojcodesandbox.model;

/**
 * @author syj
 * @date 2024/8/3 23:36
 */

import lombok.Data;

/**
 * 进程执行信息
 */
@Data
public class ExecuteMessage {
    private Integer exitValue;

    private String message;

    private String errorMessage;

    private Long time;

    private Long memory;

}
