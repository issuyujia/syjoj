package com.syj.syjoj.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.syj.syjoj.common.ErrorCode;
import com.syj.syjoj.exception.BusinessException;
import com.syj.syjoj.judge.codesandbox.CodeSandBox;
import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.syj.syjoj.judge.codesandbox.model.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;

/**
 * @author syj
 * @date 2024/7/30 22:04
 */

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 */
public class RemoteSandbox implements CodeSandBox {
    //定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {

        System.out.println("远程代码沙箱");
        String url = "http://localhost:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER,AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if(StringUtils.isBlank(responseStr)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,"executeCode remoteSandbox error,message = "+responseStr);

        }
        return JSONUtil.toBean(responseStr,ExecuteCodeResponse.class);
    }
}
