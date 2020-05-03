package com.ht.diet.serviceImpl;

import com.ht.diet.dataService.FoodDataService;
import com.ht.diet.enums.FoodClassification;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.response.FoodDetailResponse;
import com.ht.diet.response.FoodListResponse;
import com.ht.diet.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodDataService foodDataService;
    @Override
    public FoodDetailResponse findById(long id) throws NotExistException {
        return new FoodDetailResponse(foodDataService.findById(id));
    }


    @Override
    public FoodListResponse findByName(String name,int page,int pageSize) {
        Pageable pageable=PageRequest.of(page,pageSize);
        return new FoodListResponse(foodDataService.findByName(name,pageable));
    }

    @Override
    public FoodListResponse findByClassification(FoodClassification classification) {
        return new FoodListResponse(foodDataService.findByClassification(classification));
    }

    @Override
    public FoodListResponse getAll(int page,int pageSize) {
        Pageable pageable=PageRequest.of(page,pageSize);
        return new FoodListResponse(foodDataService.getAll(pageable));
    }

}
