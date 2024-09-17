package com.laolang.jx.module.system.api.user.pojo;

import com.laolang.jx.framework.common.domain.BasePojo;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserPojo extends BasePojo {
    private Long tenantId;
    private String userType;
    private String username;
    private String nickname;
    private String phone;
    private String email;
    private String password;
    private String gender;
    private String avatar;
    private String loginIp;
    private LocalDateTime loginTime;
    private String status;
    private Integer deleted = 0;
}
