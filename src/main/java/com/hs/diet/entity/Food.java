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
    private int primary_classification;

    @Column
    private int secondary_classification;

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
