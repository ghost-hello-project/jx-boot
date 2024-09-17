package com.laolang.jx.module.system.dict.dto.condition;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SelectDictTypeListCondition {
    private String name;
    private String type;
    private String groupCode;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
}
