package com.hs.diet.service;

import com.hs.diet.enums.RecipeClassification;
import com.hs.diet.exception.NotExistException;
import com.hs.diet.response.RecipeDetailResponse;
import com.hs.diet.response.RecipeListResponse;

public interface RecipeService {
    RecipeDetailResponse findById(Long id) throws NotExistException;
    RecipeListResponse findByClassification(RecipeClassification classification);
}
