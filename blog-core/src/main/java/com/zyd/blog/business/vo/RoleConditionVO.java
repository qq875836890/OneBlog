package com.zyd.blog.business.vo;

import com.zyd.blog.business.entity.Role;
import com.zyd.blog.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author
 * @version 1.0
 * @website 
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleConditionVO extends BaseConditionVO {
    private Role role;
}

