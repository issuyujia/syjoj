package com.syj.syjojbackendjudgeservice.judge.codesandbox;

/**
 * @author syj
 * @date 2024/7/30 22:34
 */


import com.syj.syjojbackendjudgeservice.judge.codesandbox.impl.ExampleCodeSandbox;
import com.syj.syjojbackendjudgeservice.judge.codesandbox.impl.RemoteSandbox;
import com.syj.syjojbackendjudgeservice.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂（根据字符串参数创建指定的代码沙箱实例）
 */
public class CodeSandboxFactory {
    /**
     * 创建代码沙箱实例
     *
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandBox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
