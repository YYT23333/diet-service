package com.ht.diet.serviceImpl;

import com.ht.diet.dataService.RecipeDataService;
import com.ht.diet.entity.Recipe;
import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.parameters.RecipeParameter;
import com.ht.diet.response.AddResponse;
import com.ht.diet.response.RecipeDetailResponse;
import com.ht.diet.response.RecipeListResponse;
import com.ht.diet.response.Response;
import com.ht.diet.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDataService recipeDataService;
    @Override
    public RecipeDetailResponse findById(long id) throws NotExistException {
        return new RecipeDetailResponse(recipeDataService.findById(id));
    }

    @Override
    public RecipeListResponse findByClassification(RecipeClassification classification) {
        return  new RecipeListResponse(recipeDataService.findByClassification(classification));
    }

    @Override
    public AddResponse create(RecipeParameter parameter) {
        return new AddResponse(recipeDataService.add(new Recipe(parameter)));
    }

    @Override
    public Response update(RecipeParameter parameter) throws NotExistException {
        recipeDataService.update(new Recipe(parameter));
        return new Response();
    }

    @Override
    public Response delete(long id) throws NotExistException {
        recipeDataService.delete(id);
        return new Response();
    }
}
