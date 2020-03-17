package com.hs.diet.dataService;

import com.hs.diet.entity.Recipe;
import com.hs.diet.enums.RecipeSecondaryClassification;

import java.util.List;

public interface RecipeDataService {
    Recipe findById(Long id);
    List<Recipe> findByClassification(RecipeSecondaryClassification classification);
    
}
