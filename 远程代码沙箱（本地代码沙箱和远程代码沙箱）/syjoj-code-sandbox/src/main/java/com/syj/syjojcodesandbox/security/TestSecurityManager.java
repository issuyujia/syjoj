package com.syj.syjojcodesandbox.security;

import cn.hutool.core.io.FileUtil;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author syj
 * @date 2024/8/4 21:54
 */
public class TestSecurityManager {
    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());
        List<String> strings = FileUtil.readLines("D:\\Code\\project\\syjoj-code-sandbox\\src\\main\\resources\\application.yml", StandardCharsets.UTF_8);
        System.out.println(strings);
    }
}
