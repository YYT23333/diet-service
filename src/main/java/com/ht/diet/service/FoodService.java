package com.ht.diet.service;

import com.ht.diet.enums.FoodClassification;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.response.FoodDetailResponse;
import com.ht.diet.response.FoodListResponse;

public interface FoodService {
    FoodDetailResponse findById(long id)throws NotExistException;
    FoodListResponse findByName(String name);
    FoodListResponse findByClassification(FoodClassification classification);
}
