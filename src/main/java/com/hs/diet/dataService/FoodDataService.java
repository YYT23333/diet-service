package com.hs.diet.dataService;

import com.hs.diet.entity.Food;
import com.hs.diet.enums.FoodClassification;
import com.hs.diet.exception.NotExistException;

import java.util.List;

public interface FoodDataService {
    Food findById(Long id) throws NotExistException;
    List<Food> findByName(String name);
    List<Food> findByClassification(FoodClassification classification);
}
