package com.laolang.jx.module.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laolang.jx.framework.mybatis.core.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends BaseEntity {
    private Long tenantId;
    private String userType;
    private String username;
    private String nickname;
    private String phone;
    private String email;
    @JsonIgnore
    private String password;
    private String gender;
    private String avatar;
    private String loginIp;
    private LocalDateTime loginTime;
    private String status;
    private Integer deleted = 0;
}
