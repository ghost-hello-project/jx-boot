package com.laolang.jx.module.system.dto;

import com.laolang.jx.module.system.dict.consts.SysUserLoginLogConsts;
import lombok.Data;

@Data
public class SysUserLoginLogInsertDto {

    private Long userId;
    private Long tenantId;
    private SysUserLoginLogConsts.LoginType loginType;
    private String loginIp;

}
