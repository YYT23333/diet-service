package com.hs.diet.enums;

public enum FoodPrimaryClassification {
    CARBOHYDRATES(1,"碳水化合物"),
    PROTEIN(2,"蛋白质"),
    FAT(3,"脂肪"),
    VITAMINS_AND_HEALTH_SUBSTANCES(4,"维他命及矿物质"),
    ORTHERS(5,"其他");
    private int index;
    private String name;
    private FoodPrimaryClassification(int index,String name){
        this.index=index;
        this.name=name;
    }
}
