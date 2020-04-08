package com.ht.diet.response;

import com.ht.diet.entity.Food;
import com.ht.diet.enums.FoodClassification;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FoodDetailItem {
    @ApiModelProperty("食物id")
    private long id;

    @ApiModelProperty("食物名称")
    private String name;

    @ApiModelProperty("类型")
    private FoodClassification classification;

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
        this.calories=food.getCalories();
        this.carbohydrate=food.getCarbohydrate();
        this.protein=food.getProtein();
        this.fat=food.getFat();
    }
}
