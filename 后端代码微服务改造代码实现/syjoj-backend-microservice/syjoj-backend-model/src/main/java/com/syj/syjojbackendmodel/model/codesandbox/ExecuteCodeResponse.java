package com.syj.syjojbackendmodel.model.codesandbox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author syj
 * @date 2024/7/30 21:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExecuteCodeResponse {
    private List<String> outputList;
    /**
     * 接口信息
     */
    private String message;
    /**
     * 执行状态
     */
    private Integer status;

    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;
}
