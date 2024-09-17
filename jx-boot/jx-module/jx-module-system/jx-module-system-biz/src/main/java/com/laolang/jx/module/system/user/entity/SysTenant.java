package com.laolang.jx.module.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.laolang.jx.framework.common.consts.CommonEntityConsts;
import com.laolang.jx.framework.mybatis.core.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("sys_tenant")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysTenant extends BaseEntity {

    private String name;
    private String code;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    /**
     * @see CommonEntityConsts.DefaultValue
     */
    private String status;
    private Integer deleted = 0;
}
