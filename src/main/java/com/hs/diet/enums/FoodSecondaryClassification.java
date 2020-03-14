package com.hs.diet.enums;

public enum FoodSecondaryClassification {
    //碳水化合物
    ALL_CARBOHYDRATES(11,"全部"),
    CEREALS_AND_PRODUCTS(12,"谷物及制品类"),
    POTATO(13,"薯类"),
    GRAINS_AND_BEANS(14,"杂粮豆类"),
    //蛋白质
    ALL_PROTEIN(21,"全部"),
    LEAN_MEAT(22,"瘦肉类"),
    FISH_AND_SHELLFISH(23,"鱼虾贝类"),
    EGGS_AND_DAIRY_PRODUCTS(24,"蛋类及乳制品"),
    SOY(25,"大豆类"),
    //脂肪
    ALL_FAT(31,"全部"),
    NUTS_AND_SEEDS(32,"坚果及种子类"),
    OIL(33,"油脂类"),
    //维生素及矿物质
    ALL_VITAMINS_AND_HEALTH_SUBSTANCES(41,"全部"),
    VEGETABLES(42,"蔬菜类"),
    FRUIT(43,"水果类"),
    //其他
    ALL_OTHERS(51,"全部"),
    OTHERS(52,"其他类"),
    INGREDIENTS(53,"配料类");

    private int index;
    private String name;
    private FoodSecondaryClassification(int index,String name){
        this.index=index;
        this.name=name;
    }
}
