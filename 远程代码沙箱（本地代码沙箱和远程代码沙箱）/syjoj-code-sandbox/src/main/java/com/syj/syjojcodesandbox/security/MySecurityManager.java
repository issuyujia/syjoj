package com.syj.syjojcodesandbox.security;

import java.security.Permission;

/**
 * @author syj
 * @date 2024/8/4 21:42
 */
public class MySecurityManager extends SecurityManager {
    /**
     * 检查所有的权限
     *
     * @param perm
     */
    @Override
    public void checkPermission(Permission perm) {
//        super.checkPermission(perm);
    }

    /**
     * 检测程序是否可执行
     *
     * @param cmd
     */
    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("checkExec 权限异常：" + cmd);
    }

    /**
     * 检测程序是否可读
     *
     * @param file
     */
    @Override
    public void checkRead(String file) {
//        throw new SecurityException("checkRead 权限异常：" + file);
    }

    /**
     * 检测文件是否可写
     *
     * @param file
     */
    @Override
    public void checkWrite(String file) {
//        throw new SecurityException("checkWrite 权限异常：" + file);
    }

    /**
     * 检测文件是否可删除
     *
     * @param file
     */
    @Override
    public void checkDelete(String file) {
//        throw new SecurityException("checkDelete 权限异常：" + file);
    }

    /**
     * 检测程序是否允许连接网络
     *
     * @param host
     * @param port
     */
    @Override
    public void checkConnect(String host, int port) {
//        throw new SecurityException("checkConnect 权限异常：" + host + ":" + port);
    }
}
