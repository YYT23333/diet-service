package com.hs.diet.entity;

import javax.persistence.Embeddable;

@Embeddable
public class DietItem {
    private int type;
    private String name;
    private double weight;
}
