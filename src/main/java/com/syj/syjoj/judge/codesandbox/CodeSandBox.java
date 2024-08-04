package com.syj.syjoj.judge.codesandbox;

/**
 * @author syj
 * @date 2024/7/30 21:53
 */

import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeResponse;

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
