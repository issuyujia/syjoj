package com.syj.syjojcodesandbox.security;

import java.security.Permission;

/**
 * @author syj
 * @date 2024/8/4 21:41
 */
public class DenySecurityManager extends SecurityManager {
    /**
     * 禁止所有的权限
     *
     * @param perm
     */
    @Override
    public void checkPermission(Permission perm) {
        throw new RuntimeException();
    }
}
