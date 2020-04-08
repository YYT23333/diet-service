package com.ht.diet.entity;

import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.parameters.RecipeParameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private RecipeClassification classification;

    @Column
    private String description;

    @Column
    private double calories;

    @Column
    private double carbohydrate;

    @Column
    private double protein;

    @Column
    private double fat;

    @Column
    private String imgUrl;

    @ElementCollection
    private List<Ingredient> ingredients;

    @ElementCollection
    private List<Step> steps;

    @Column
    private int isValid=1;

    public Recipe(RecipeParameter parameter){
        this.id=parameter.getId();
        this.name=parameter.getName();
        this.classification=parameter.getClassification();
        this.description=parameter.getDescription();
        this.calories=parameter.getCalories();
        this.carbohydrate=parameter.getCarbohydrate();
        this.protein=parameter.getProtein();
        this.fat=parameter.getFat();
        this.imgUrl=parameter.getImgUrl();
        this.ingredients=parameter.getIngredients();
        this.steps=parameter.getSteps();

    }

}
