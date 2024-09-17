package com.laolang.jx.module.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.laolang.jx.framework.mybatis.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("sys_menu")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenu extends BaseEntity {
    private String title;
    private Long parentId;
    private Integer orderNum;
    private String platformType;
    private String path;
    private String component;
    private String query;
    private String routeName;
    private String frame;
    private String cache;
    private String menuType;
    private String visible;
    private String perms;
    private String icon;
    private String status;
    private Integer deleted = 0;
}
