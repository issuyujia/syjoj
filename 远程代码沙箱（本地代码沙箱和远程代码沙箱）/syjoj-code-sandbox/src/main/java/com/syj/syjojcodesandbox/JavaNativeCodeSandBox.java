package com.syj.syjojcodesandbox;

import com.syj.syjojcodesandbox.model.ExecuteCodeRequest;
import com.syj.syjojcodesandbox.model.ExecuteCodeResponse;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 *@author syj
 *@date 2024/8/15 22:13
 *
*/

/**
 * java原生沙箱实现(直接复用模板方法)
 */
@Component
public class JavaNativeCodeSandBox extends JavaCodeSandboxTemplate{
    @Override
    public File saveCodeTofile(String code) {
        return super.saveCodeTofile(code);
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return super.executeCode(executeCodeRequest);
    }
}
