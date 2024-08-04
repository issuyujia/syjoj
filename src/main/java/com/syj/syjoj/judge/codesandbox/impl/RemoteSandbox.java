package com.syj.syjoj.judge.codesandbox.impl;

import com.syj.syjoj.judge.codesandbox.CodeSandBox;
import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author syj
 * @date 2024/7/30 22:04
 */

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 */
public class RemoteSandbox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        return null;
    }
}
