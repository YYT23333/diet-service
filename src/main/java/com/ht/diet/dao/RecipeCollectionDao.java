package com.ht.diet.dao;

import com.ht.diet.entity.Recipe;
import com.ht.diet.entity.RecipeCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeCollectionDao extends JpaRepository<RecipeCollection,String> {
    List<RecipeCollection> findByUserId(long userId);
    Optional<RecipeCollection> findByUserIdAndRecipeId(long userId, long recipeId);
}
