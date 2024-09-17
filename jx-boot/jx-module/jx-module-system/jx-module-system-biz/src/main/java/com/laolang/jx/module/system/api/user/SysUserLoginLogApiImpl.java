package com.laolang.jx.module.system.api.user;

import com.laolang.jx.module.system.api.user.dto.SysUserLoginLogInsertDto;
import com.laolang.jx.module.system.user.entity.SysUser;
import com.laolang.jx.module.system.user.entity.SysUserLoginLog;
import com.laolang.jx.module.system.user.mapper.SysUserLoginLogMapper;
import com.laolang.jx.module.system.user.service.SysUserService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SysUserLoginLogApiImpl implements SysUserLoginLogApi {

    private final SysUserLoginLogMapper sysUserLoginLogMapper;
    private final SysUserService sysUserService;


    @Override
    public void insertLoginLog(SysUserLoginLogInsertDto dto) {
        SysUser sysUser = sysUserService.getById(dto.getUserId());

        SysUserLoginLog record = new SysUserLoginLog();
        record.setUserId(sysUser.getId());
        record.setTenantId(sysUser.getTenantId());
        record.setLoginIp(dto.getLoginIp());
        record.setLoginTime(LocalDateTime.now());
        record.setLoginType(dto.getLoginType().getValue());
        record.setCreateBy(sysUser.getUsername());
        record.setCreateTime(record.getLoginTime());
        record.setUpdateBy(sysUser.getUsername());
        record.setUpdateTime(record.getLoginTime());
        record.setVersion(1);

        sysUserLoginLogMapper.insert(record);
    }
}
