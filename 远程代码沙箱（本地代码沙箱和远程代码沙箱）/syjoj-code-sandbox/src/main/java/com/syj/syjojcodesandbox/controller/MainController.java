package com.syj.syjojcodesandbox.controller;

import com.syj.syjojcodesandbox.JavaNativeCodeSandBox;
import com.syj.syjojcodesandbox.model.ExecuteCodeRequest;
import com.syj.syjojcodesandbox.model.ExecuteCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author syj
 * @date 2024/8/3 20:14
 */
@RestController("/")
public class MainController {
    //定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Resource
    private JavaNativeCodeSandBox javaNativeCodeSandBox;

    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCode")
    ExecuteCodeResponse executeCode(@RequestBody ExecuteCodeRequest executeCodeRequest,
                                    HttpServletRequest request, HttpServletResponse response) {
        //进行基本的校验认证
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if(!AUTH_REQUEST_SECRET.equals(authHeader)){
            //没有权限
            response.setStatus(403);
            return null;
        }
        if(executeCodeRequest==null){
            throw new RuntimeException("请求参数为空");
        }
        return javaNativeCodeSandBox.executeCode(executeCodeRequest);
    }
}
