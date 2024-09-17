package com.laolang.jx.module.system.api.user.dto;

import com.laolang.jx.module.system.api.dict.consts.SysUserLoginLogConsts;
import lombok.Data;

@Data
public class SysUserLoginLogInsertDto {

    private Long userId;
    private Long tenantId;
    private SysUserLoginLogConsts.LoginType loginType;
    private String loginIp;

}
