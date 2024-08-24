package com.syj.syjojbackendjudgeservice.judge.codesandbox;

/**
 * @author syj
 * @date 2024/7/30 21:53
 */


import com.syj.syjojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.syj.syjojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandBox {
    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
