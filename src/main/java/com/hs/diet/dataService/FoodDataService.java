package com.hs.diet.dataService;

import com.hs.diet.entity.Food;
import com.hs.diet.enums.FoodSecondaryClassification;
import com.hs.diet.exception.NotExistException;

import java.util.List;
import java.util.Optional;

public interface FoodDataService {
    Food findById(Long id) throws NotExistException;
    List<Food> findByName(String name);
    List<Food> findByClassification(FoodSecondaryClassification classification);
}
