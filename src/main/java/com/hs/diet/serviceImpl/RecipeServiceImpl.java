package com.hs.diet.serviceImpl;

import com.hs.diet.dataService.RecipeDataService;
import com.hs.diet.enums.RecipeClassification;
import com.hs.diet.exception.NotExistException;
import com.hs.diet.response.RecipeDetailResponse;
import com.hs.diet.response.RecipeListResponse;
import com.hs.diet.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDataService recipeDataService;
    @Override
    public RecipeDetailResponse findById(Long id) throws NotExistException {
        return new RecipeDetailResponse(recipeDataService.findById(id));
    }

    @Override
    public RecipeListResponse findByClassification(RecipeClassification classification) {
        return  new RecipeListResponse(recipeDataService.findByClassification(classification));
    }
}
