package com.laolang.jx.module.system.api.user;

import com.laolang.jx.module.system.api.user.pojo.SysUserPojo;

public interface SysUserApi {

    SysUserPojo getUserByUsername(String username);
}
