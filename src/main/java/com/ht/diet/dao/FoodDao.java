package com.ht.diet.dao;


import com.ht.diet.entity.Food;
import com.ht.diet.enums.FoodClassification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FoodDao extends JpaRepository<Food,String> {
    Optional<Food> findById(long id);
    @Query(nativeQuery = true,
            value = "select * from food where food.name like %?1%",
            countQuery = "select * from food where food.name like %?1%")
    List<Food> findByName(String name, Pageable pageable);
    @Query(nativeQuery = true,
            value = "select * from food",
            countQuery = "select * from")
    List<Food> getAll(Pageable pageable);
    List<Food> findByClassification(FoodClassification classification);
}
