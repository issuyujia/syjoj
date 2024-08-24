package com.syj.syjojcodesandbox;

/**
 * @author syj
 * @date 2024/7/30 21:53
 */
import com.syj.syjojcodesandbox.model.ExecuteCodeRequest;
import com.syj.syjojcodesandbox.model.ExecuteCodeResponse;

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
