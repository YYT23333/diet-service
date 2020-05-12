package com.ht.diet.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class DietRecordListItem {
    @ApiModelProperty("星期几")
    private int dayOfWeek;
    @ApiModelProperty("卡路里")
    private double calories;
    @ApiModelProperty("饮食记录")
    private List<DietRecordListItemDetailItem> records;

}
