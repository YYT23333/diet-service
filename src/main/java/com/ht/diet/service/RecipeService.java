package com.ht.diet.service;

import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.exception.AlreadyExistException;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.parameters.RecipeParameter;
import com.ht.diet.response.*;

public interface RecipeService {
    RecipeDetailResponse findById(long id);
    RecipeListResponse findByClassification(RecipeClassification classification,int page,int pageSize);
    AddResponse create(RecipeParameter parameter);
    Response update(RecipeParameter parameter);
    Response delete(long id);
    RecipeListResponse findCollectionRecipeByUserId(long userId);
    AddResponse collect(long userId,long recipeId);
    Response deleteCollection(long userId,long recipeId);
    RecipeClassificationCountResponse countByRecipeClassification();
    BooleanResponse isUserCollectRecipe(long userId,long recipeId);
}
