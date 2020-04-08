package com.ht.diet.dataService;

import com.ht.diet.entity.Recipe;
import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.exception.NotExistException;

import java.util.List;

public interface RecipeDataService {
    Recipe findById(long id) throws NotExistException;
    List<Recipe> findByClassification(RecipeClassification classification);
    long add(Recipe recipe);
    void update(Recipe recipe)throws NotExistException;
    void delete(long id)throws NotExistException;
    
}
