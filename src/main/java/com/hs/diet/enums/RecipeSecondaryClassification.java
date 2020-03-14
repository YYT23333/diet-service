package com.hs.diet.enums;

public enum RecipeSecondaryClassification {
    //套餐
    BENTO_COMBINATION(11,"便当组合"),
    BREAKFAST_COMBINATION(12,"早餐组合"),
    LUNCH_COMBINATION(13,"午餐组合"),
    SUPER_COMBINATION(14,"晚餐组合"),
    //场景
    BREAKFAST(21,"早餐"),
    LUNCH(22,"午餐"),
    SUPPER(23,"晚餐"),
    SNACKS(24,"加餐"),
    //菜式
    CHINESE(31,"中式"),
    WESTERN(32,"西式"),
    //类型
    STAPLE_FOOD(41,"主食"),
    MEAT(42,"肉菜"),
    VEGETABLES(43,"蔬菜"),
    SOUP(44,"汤羹"),
    BEAN_PRODUCTS(45,"大豆制品"),
    DRINK(46,"饮品"),
    SEAFOOD(47,"海鲜"),
    BARBECUE(48,"烧烤");
    private int index;
    private String name;
    private RecipeSecondaryClassification(int index,String name){
        this.index=index;
        this.name=name;
    }
}
