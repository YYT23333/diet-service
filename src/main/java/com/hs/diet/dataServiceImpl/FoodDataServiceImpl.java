package com.hs.diet.dataServiceImpl;

import com.hs.diet.dao.FoodDao;
import com.hs.diet.dataService.FoodDataService;
import com.hs.diet.entity.Food;
import com.hs.diet.enums.FoodSecondaryClassification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodDataServiceImpl implements FoodDataService {
    @Autowired
    private FoodDao foodDao;
    @Override
    public Food findById(Long id) {
        return foodDao.findById(id);
    }

    @Override
    public List<Food> findByName(String name) {
        return foodDao.findByName(name);
    }

    @Override
    public List<Food> findByClassification(FoodSecondaryClassification classification) {
        return foodDao.findByClassification(classification);
    }
}
