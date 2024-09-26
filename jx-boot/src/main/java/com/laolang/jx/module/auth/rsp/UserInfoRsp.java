package com.laolang.jx.module.auth.rsp;

import com.laolang.jx.module.system.user.entity.SysUser;
import java.util.Set;
import lombok.Data;

@Data
public class UserInfoRsp {

    private Set<String> perms;
    private Set<String> roles;
    private SysUser user;
}
