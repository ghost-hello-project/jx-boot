package com.laolang.jx.framework.mybatis.core;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类基类,所有的基类都要继承此类.
 *
 * @author laolang
 * @version 0.1
 */
@NoArgsConstructor
@Data
public class BaseEntity {

    /**
     * id.
     */
    private Long id;

    /**
     * 创建人.
     */
    private String createBy;

    /**
     * 创建时间.
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人.
     */
    private String updateBy;

    /**
     * 最后修改时间.
     */
    private LocalDateTime updateTime;

    private String remark;

    /**
     * 乐观锁.
     */
    @Version
    private Integer version;
}

