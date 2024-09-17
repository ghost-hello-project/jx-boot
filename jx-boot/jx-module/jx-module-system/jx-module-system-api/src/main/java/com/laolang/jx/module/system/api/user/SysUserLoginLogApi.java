package com.laolang.jx.module.system.api.user;

import com.laolang.jx.module.system.api.user.dto.SysUserLoginLogInsertDto;

public interface SysUserLoginLogApi {

    void insertLoginLog(SysUserLoginLogInsertDto dto);
}
