package com.zyd.blog.core.shiro;

import java.util.Map;

/**
 * @author
 * @version 1.0
 * @website 
 * @date 2019/2/11 10:07
 * @since 1.8
 */
public interface ShiroService {

    Map<String, String> loadFilterChainDefinitions();

    void updatePermission();

    void reloadAuthorizingByRoleId(Long roleId);
}
