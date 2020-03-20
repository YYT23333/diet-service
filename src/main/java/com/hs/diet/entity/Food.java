package com.hs.diet.entity;

import com.hs.diet.enums.FoodPrimaryClassification;
import com.hs.diet.enums.FoodSecondaryClassification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private  String name;

    @Column
    private FoodPrimaryClassification primaryClassification;

    @Column
    private FoodSecondaryClassification secondaryClassification;

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

}
