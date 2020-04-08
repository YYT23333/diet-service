package com.ht.diet.dao;


import com.ht.diet.entity.Food;
import com.ht.diet.enums.FoodClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodDao extends JpaRepository<Food,String> {
    Optional<Food> findById(long id);
    List<Food> findByName(String name);
    List<Food> findByClassification(FoodClassification classification);
}
