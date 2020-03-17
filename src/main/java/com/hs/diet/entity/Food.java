package com.hs.diet.entity;

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
    private int primaryClassification;

    @Column
    private int secondaryClassification;

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
