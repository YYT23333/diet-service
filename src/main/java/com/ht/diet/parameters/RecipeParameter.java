package com.ht.diet.parameters;

import com.ht.diet.entity.Ingredient;
import com.ht.diet.entity.Step;
import com.ht.diet.enums.RecipeClassification;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class RecipeParameter {
    @ApiModelProperty("食谱id(新建不传)")
    private long id;
    @ApiModelProperty("食谱名称")
    private String name;

    @ApiModelProperty("食谱类型")
    private RecipeClassification classification;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("卡路里")
    private double calories;

    @ApiModelProperty("碳水化合物")
    private double carbohydrate;

    @ApiModelProperty("蛋白质")
    private double protein;

    @ApiModelProperty("脂肪")
    private double fat;

    @ApiModelProperty("图片地址")
    private String imgUrl;

    @ApiModelProperty("原料")
    private List<Ingredient> ingredients;

    @ApiModelProperty("步骤")
    private List<Step> steps;
}
