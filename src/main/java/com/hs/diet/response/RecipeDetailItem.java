package com.hs.diet.response;

import com.hs.diet.entity.Ingredient;
import com.hs.diet.entity.Recipe;
import com.hs.diet.entity.Step;
import com.hs.diet.enums.RecipeClassification;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class RecipeDetailItem {
    @ApiModelProperty("食谱id")
    private Long id;

    @ApiModelProperty("食谱名称")
    private String name;

    @ApiModelProperty("食谱分类")
    private RecipeClassification classification;

    @ApiModelProperty("食谱描述")
    private String description;

    @ApiModelProperty("热量")
    private double calories;

    @ApiModelProperty("碳水化合物")
    private double carbohydrate;

    @ApiModelProperty("蛋白质")
    private double protein;

    @ApiModelProperty("脂肪")
    private double fat;

    @ApiModelProperty("原料")
    private List<Ingredient> ingredients;

    @ApiModelProperty("步骤")
    private List<Step> steps;

    public RecipeDetailItem(Recipe recipe){
        this.id=recipe.getId();
        this.name=recipe.getName();
        this.classification=recipe.getClassification();
        this.description=recipe.getDescription();
        this.calories=recipe.getCalories();
        this.carbohydrate=recipe.getCarbohydrate();
        this.fat=recipe.getFat();
        this.ingredients=recipe.getIngredients();
        this.steps=recipe.getSteps();
    }
}
