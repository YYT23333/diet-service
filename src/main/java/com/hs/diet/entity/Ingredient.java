package com.hs.diet.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Ingredient {
    private String name;
    private double weight;
}
