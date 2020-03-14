package com.hs.diet.dataServiceImpl;

import com.hs.diet.dao.RecipeDao;
import com.hs.diet.entity.Recipe;
import com.hs.diet.enums.RecipeSecondaryClassification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeDataService implements com.hs.diet.dataService.RecipeDataService {
    @Autowired
    private RecipeDao recipeDao;
    @Override
    public Recipe findById(Long id) {
        return recipeDao.findById(id);
    }

    @Override
    public List<Recipe> findByClassification(RecipeSecondaryClassification classification) {
        return recipeDao.findBySecondaryClassification(classification);
    }
}
