package com.ht.diet.parameters;

import com.ht.diet.entity.DietItem;
import com.ht.diet.enums.DietRecordType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel
public class DietRecordParameter {
    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("饮食记录类型")
    private DietRecordType type;

    @ApiModelProperty("卡路里")
    private double calories;

    @ApiModelProperty("饮食记录内容")
    private List<DietItem> dietItems;
}
