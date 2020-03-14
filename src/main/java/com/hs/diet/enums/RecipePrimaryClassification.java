package com.hs.diet.enums;

public enum RecipePrimaryClassification {
    PACKAGE(1,"套餐"),
    SCENARIO(2,"场景"),
    DISHES(3,"菜式"),
    TYPE(4,"类型");
    private int index;
    private String name;
    private RecipePrimaryClassification(int index,String name){
        this.index=index;
        this.name=name;
    }}
