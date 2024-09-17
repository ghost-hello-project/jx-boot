package com.laolang.jx.module.system.dict.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.laolang.jx.framework.common.consts.CommonEntityConsts;
import com.laolang.jx.framework.mybatis.core.BaseEntity;
import com.laolang.jx.module.system.api.dict.consts.SysDictConsts;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统字典实体类.
 *
 * @author laolang
 * @version 0.1
 */
@TableName("sys_dict_type")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictType extends BaseEntity {
    private String name;
    /**
     * @see SysDictConsts.Type
     */
    private String type;
    /**
     * @see SysDictConsts.GroupCode
     * @see SysDictConsts.Module
     */
    private String groupCode;
    /**
     * @see CommonEntityConsts.DefaultValue
     */
    private String status;
    private Integer deleted = 0;
}
