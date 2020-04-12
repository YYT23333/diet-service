package com.ht.diet.dataService;

import com.ht.diet.entity.RecipeCollection;
import com.ht.diet.exception.NotExistException;

import java.util.List;

public interface RecipeCollectionDataService {
    List<RecipeCollection> findByUserId(long userId);
    long add(RecipeCollection collection);
    void deleteByUserIdAndRecipeId(long userId,long recipeId)throws NotExistException;
}
