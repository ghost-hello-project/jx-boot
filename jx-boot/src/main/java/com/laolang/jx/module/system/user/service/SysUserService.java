package com.laolang.jx.module.system.user.service;

import com.laolang.jx.framework.mybatis.core.BaseService;
import com.laolang.jx.module.system.user.entity.SysUser;

public interface SysUserService extends BaseService<SysUser> {
    SysUser getUserByUsername(String username);
}
