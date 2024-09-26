package com.laolang.jx.module.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.laolang.jx.framework.mybatis.core.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("sys_user_login_log")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserLoginLog extends BaseEntity {
    private Long userId;
    private Long tenantId;
    private String loginIp;
    private LocalDateTime loginTime;
    private String loginType;
}
