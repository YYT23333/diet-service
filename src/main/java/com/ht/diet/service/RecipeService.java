package com.ht.diet.service;

import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.parameters.RecipeParameter;
import com.ht.diet.response.*;

public interface RecipeService {
    RecipeDetailResponse findById(long id) throws NotExistException;
    RecipeListResponse findByClassification(RecipeClassification classification,int page,int pageSize);
    AddResponse create(RecipeParameter parameter);
    Response update(RecipeParameter parameter)throws NotExistException;
    Response delete(long id)throws NotExistException;
    RecipeListResponse findCollectionRecipeByUserId(long userId);
    AddResponse collect(long userId,long recipeId) throws NotExistException;
    Response deleteCollection(long userId,long recipeId) throws NotExistException;
    RecipeClassificationCountResponse countByRecipeClassification();
}
