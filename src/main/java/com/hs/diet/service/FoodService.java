package com.hs.diet.service;

import com.hs.diet.enums.FoodSecondaryClassification;
import com.hs.diet.exception.NotExistException;
import com.hs.diet.response.FoodDetailResponse;
import com.hs.diet.response.FoodListResponse;

public interface FoodService {
    FoodDetailResponse findById(Long id)throws NotExistException;
    FoodListResponse findByName(String name);
    FoodListResponse findByClassification(FoodSecondaryClassification classification);
}
