package com.hs.diet.dao;

import com.hs.diet.entity.Recipe;
import com.hs.diet.enums.RecipeSecondaryClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDao extends JpaRepository<Recipe,String> {
    Recipe findById(Long id);
    List<Recipe> findBySecondaryClassification(RecipeSecondaryClassification classification);
}
