package com.hs.diet.serviceImpl;

import com.hs.diet.dataService.FoodDataService;
import com.hs.diet.enums.FoodSecondaryClassification;
import com.hs.diet.exception.NotExistException;
import com.hs.diet.response.FoodDetailResponse;
import com.hs.diet.response.FoodListResponse;
import com.hs.diet.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodDataService foodDataService;
    @Override
    public FoodDetailResponse findById(Long id) throws NotExistException {
        return new FoodDetailResponse(foodDataService.findById(id));
    }

    @Override
    public FoodListResponse findByName(String name) {
        return new FoodListResponse(foodDataService.findByName(name));
    }

    @Override
    public FoodListResponse findByClassification(FoodSecondaryClassification classification) {
        return new FoodListResponse(foodDataService.findByClassification(classification));
    }
}
