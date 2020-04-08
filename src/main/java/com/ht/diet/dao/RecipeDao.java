package com.ht.diet.dao;

import com.ht.diet.entity.Recipe;
import com.ht.diet.enums.RecipeClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeDao extends JpaRepository<Recipe,String> {
    Optional<Recipe> findById(long id);
    Optional<Recipe> findByIdAndIsValid(long id,int isValid);
    List<Recipe> findByClassificationAndIsValid(RecipeClassification classification,int isValid);
}
