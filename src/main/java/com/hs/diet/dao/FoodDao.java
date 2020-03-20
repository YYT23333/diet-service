package com.hs.diet.dao;


import com.hs.diet.entity.Food;
import com.hs.diet.enums.FoodSecondaryClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodDao extends JpaRepository<Food,String> {
    Optional<Food> findById(Long id);
    List<Food> findByName(String name);
    List<Food> findBySecondaryClassification(FoodSecondaryClassification secondaryClassification);
}
