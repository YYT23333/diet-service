package com.hs.diet.dataService;

import com.hs.diet.entity.Food;
import com.hs.diet.enums.FoodSecondaryClassification;

import java.util.List;

public interface FoodDataService {
    Food findById(Long id);
    List<Food> findByName(String name);
    List<Food> findByClassification(FoodSecondaryClassification classification);
}
