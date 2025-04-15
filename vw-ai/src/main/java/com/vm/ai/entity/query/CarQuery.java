package com.vm.ai.entity.query;

import lombok.Data;
import org.springframework.ai.tool.annotation.ToolParam;

import java.util.List;

@Data
public class CarQuery {

    @ToolParam(required = false, description = "汽车类型：轿车、SUV、Crozz、其它")
    private String type;
    @ToolParam(required = false, description = "车价类型：0-(0-10万)，1-(10-20万)，2-(20-30万)、3-(30-40万)、4-(40万以上)")
    private Integer prince_level;
    @ToolParam(required = false, description = "排序方式")
    private List<CarQuery.Sort> sorts;

    @Data
    public static class Sort {
        @ToolParam(required = false, description = "排序字段: price或duration")
        private String field;
        @ToolParam(required = false, description = "是否是升序: true/false")
        private Boolean asc;
    }
}
