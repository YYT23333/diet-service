package com.hs.diet.response;

import com.hs.diet.entity.Food;
import com.hs.diet.enums.FoodPrimaryClassification;
import com.hs.diet.enums.FoodSecondaryClassification;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel
public class FoodDetailItem {
    @ApiModelProperty("食物id")
    private Long id;

    @ApiModelProperty("食物名称")
    private  String name;

    @ApiModelProperty("食物一级分类")
    private FoodPrimaryClassification primaryClassification;

    @ApiModelProperty("食物二级分类")
    private FoodSecondaryClassification secondaryClassification;

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

    public FoodDetailItem(Food food){
        this.id=food.getId();
        this.name=food.getName();
        this.primaryClassification=food.getPrimaryClassification();
        this.secondaryClassification=food.getSecondaryClassification();
        this.description=food.getDescription();
        this.calories=food.getCalories();
        this.carbohydrate=food.getCarbohydrate();
        this.protein=food.getProtein();
        this.fat=food.getFat();
    }
}
