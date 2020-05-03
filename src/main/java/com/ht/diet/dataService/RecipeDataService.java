package com.ht.diet.dataService;

import com.ht.diet.entity.Recipe;
import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.exception.NotExistException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecipeDataService {
    Recipe findById(long id) throws NotExistException;
    List<Recipe> findByClassification(RecipeClassification classification, Pageable pageable);
    long add(Recipe recipe);
    void update(Recipe recipe)throws NotExistException;
    void delete(long id)throws NotExistException;
    List countByClassification();
    
}
