package com.syj.syjojbackendjudgeservice.judge.codesandbox.impl;


/**
 * @author syj
 * @date 2024/7/30 22:06
 */

import com.syj.syjojbackendjudgeservice.judge.codesandbox.CodeSandBox;
import com.syj.syjojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.syj.syjojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 第三方代码沙箱（调用网上现成的代码沙箱）
 */
public class ThirdPartyCodeSandbox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
