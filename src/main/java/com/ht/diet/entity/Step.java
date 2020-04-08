package com.ht.diet.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@ApiModel
@Data
public class Step {
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("图片地址")
    private String imgUrl;
    @ApiModelProperty("步骤序号")
    private int stepNo;
}
