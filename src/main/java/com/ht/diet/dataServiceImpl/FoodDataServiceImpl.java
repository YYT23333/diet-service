package com.ht.diet.dataServiceImpl;

import com.ht.diet.dao.FoodDao;
import com.ht.diet.dataService.FoodDataService;
import com.ht.diet.entity.Food;
import com.ht.diet.enums.FoodClassification;
import com.ht.diet.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodDataServiceImpl implements FoodDataService {
    @Autowired
    private FoodDao foodDao;
    @Override
    public Food findById(long id) throws NotExistException {
        Optional<Food> optional=foodDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw new NotExistException("Food ID:",id);
        }
    }

    @Override
    public List<Food> findByName(String name,Pageable pageable) {
        return foodDao.findByName(name,pageable);
    }

    @Override
    public List<Food> findByClassification(FoodClassification classification) {
        return foodDao.findByClassification(classification);
    }

    @Override
    public List<Food> getAll(Pageable pageable) {
        return foodDao.getAll(pageable);
    }

}
