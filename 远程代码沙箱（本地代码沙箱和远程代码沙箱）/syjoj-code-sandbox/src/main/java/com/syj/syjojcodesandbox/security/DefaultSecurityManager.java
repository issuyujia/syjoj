package com.syj.syjojcodesandbox.security;

/**
 * @author syj
 * @date 2024/8/4 21:32
 */

import java.security.Permission;

/**
 * 默认的安全管理器
 */
public class DefaultSecurityManager extends SecurityManager {
    /**
     * 检查所有的权限
     *
     * @param perm
     */
    @Override
    public void checkPermission(Permission perm) {
        System.out.println("默认不做任何限制");
        System.out.println(perm);
        super.checkPermission(perm);
    }
}
