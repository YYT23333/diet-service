package com.ht.diet.response;

import com.ht.diet.enums.DietRecordType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class DietRecordListItemDetailItem {
    @ApiModelProperty("类型")
    private DietRecordType type;
    @ApiModelProperty("饮食记录Id")
    private long dietRecordId;
    @ApiModelProperty("卡路里")
    private double calories;
}
