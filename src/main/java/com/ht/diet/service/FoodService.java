package com.ht.diet.service;

import com.ht.diet.enums.FoodClassification;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.response.FoodDetailResponse;
import com.ht.diet.response.FoodListResponse;
import org.springframework.data.domain.Pageable;

public interface FoodService {
    FoodDetailResponse findById(long id)throws NotExistException;
    FoodListResponse findByName(String name,int page,int pageSize);
    FoodListResponse findByClassification(FoodClassification classification);
    FoodListResponse getAll(int page,int pageSize);
}
