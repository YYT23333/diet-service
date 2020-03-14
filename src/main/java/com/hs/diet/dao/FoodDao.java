package com.hs.diet.dao;


import com.hs.diet.entity.Food;
import com.hs.diet.enums.FoodSecondaryClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodDao extends JpaRepository<Food,String> {
    Food findById(Long id);
    List<Food> findByName(String name);
    List<Food> findByClassification(FoodSecondaryClassification classification);
}
