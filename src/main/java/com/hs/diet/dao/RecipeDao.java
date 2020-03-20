package com.hs.diet.dao;

import com.hs.diet.entity.Recipe;
import com.hs.diet.enums.RecipeClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeDao extends JpaRepository<Recipe,String> {
    Optional<Recipe> findById(Long id);
    List<Recipe> findByClassification(RecipeClassification classification);
}
