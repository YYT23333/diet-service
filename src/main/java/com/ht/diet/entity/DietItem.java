package com.ht.diet.entity;

import com.ht.diet.enums.DietItemType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@ApiModel
@Data
public class DietItem {
    @ApiModelProperty("类型")
    private DietItemType type;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("重量")
    private double weight;
    @ApiModelProperty("卡路里")
    private double calories;
}
