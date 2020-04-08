package com.ht.diet.dataService;

import com.ht.diet.entity.Food;
import com.ht.diet.enums.FoodClassification;
import com.ht.diet.exception.NotExistException;

import java.util.List;

public interface FoodDataService {
    Food findById(long id) throws NotExistException;
    List<Food> findByName(String name);
    List<Food> findByClassification(FoodClassification classification);
}
