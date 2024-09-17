package com.laolang.jx.module.auth.rsp;

import com.laolang.jx.module.system.api.user.pojo.SysUserPojo;
import java.util.Set;
import lombok.Data;

@Data
public class UserInfoRsp {

    private Set<String> perms;
    private Set<String> roles;
    private SysUserPojo user;
}
