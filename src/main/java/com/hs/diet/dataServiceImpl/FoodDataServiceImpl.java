package com.hs.diet.dataServiceImpl;

import com.hs.diet.dao.FoodDao;
import com.hs.diet.dataService.FoodDataService;
import com.hs.diet.entity.Food;
import com.hs.diet.enums.FoodSecondaryClassification;
import com.hs.diet.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodDataServiceImpl implements FoodDataService {
    @Autowired
    private FoodDao foodDao;
    @Override
    public Food findById(Long id) throws NotExistException {
        Optional<Food> optional=foodDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw new NotExistException("Food ID:",id);
        }
    }

    @Override
    public List<Food> findByName(String name) {
        return foodDao.findByName(name);
    }

    @Override
    public List<Food> findByClassification(FoodSecondaryClassification classification) {
        return foodDao.findBySecondaryClassification(classification);
    }
}
