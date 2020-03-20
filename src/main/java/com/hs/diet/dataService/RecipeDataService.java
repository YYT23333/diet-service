package com.hs.diet.dataService;

import com.hs.diet.entity.Recipe;
import com.hs.diet.enums.RecipeClassification;
import com.hs.diet.exception.NotExistException;

import java.util.List;
import java.util.Optional;

public interface RecipeDataService {
    Recipe findById(Long id) throws NotExistException;
    List<Recipe> findByClassification(RecipeClassification classification);
    
}
