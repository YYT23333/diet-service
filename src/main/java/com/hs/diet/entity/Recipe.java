package com.hs.diet.entity;

import com.hs.diet.enums.RecipePrimaryClassification;
import com.hs.diet.enums.RecipeSecondaryClassification;
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
    private Long id;

    @Column
    private String name;

    @Column
    private RecipePrimaryClassification primaryClassification;

    @Column
    private RecipeSecondaryClassification secondaryClassification;

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

    @ElementCollection
    private List<Ingredient> ingredients;

    @ElementCollection
    private List<Step> steps;


}
