package com.ht.diet.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@ApiModel
@Data
public class Ingredient {
    @ApiModelProperty("食材名称")
    private String name;
    @ApiModelProperty("食材重量")
    private double weight;
}
