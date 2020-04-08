package com.ht.diet.entity;

import com.ht.diet.enums.FoodClassification;
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
    private long id;

    @Column
    private  String name;

    @Column
    private FoodClassification classification;

    @Column
    private double calories;

    @Column
    private double carbohydrate;

    @Column
    private double protein;

    @Column
    private double fat;

}
