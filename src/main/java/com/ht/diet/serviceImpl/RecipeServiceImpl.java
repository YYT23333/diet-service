package com.ht.diet.serviceImpl;

import com.ht.diet.dataService.RecipeCollectionDataService;
import com.ht.diet.dataService.RecipeDataService;
import com.ht.diet.entity.Recipe;
import com.ht.diet.entity.RecipeCollection;
import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.exception.AlreadyExistException;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.parameters.RecipeParameter;
import com.ht.diet.response.*;
import com.ht.diet.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDataService recipeDataService;
    @Autowired
    private RecipeCollectionDataService recipeCollectionDataService;
    @Override
    public RecipeDetailResponse findById(long id) {
        try {
            return new RecipeDetailResponse(recipeDataService.findById(id));
        } catch (NotExistException e) {
            return new RecipeDetailResponse(500,e.getMessage());
        }
    }

    @Override
    public RecipeListResponse findByClassification(RecipeClassification classification,int page,int pageSize) {
        Pageable pageable=PageRequest.of(page,pageSize);
        return  new RecipeListResponse(recipeDataService.findByClassification(classification,pageable));
    }

    @Override
    public AddResponse create(RecipeParameter parameter) {
        return new AddResponse(recipeDataService.add(new Recipe(parameter)));
    }

    @Override
    public Response update(RecipeParameter parameter){
        try {
            recipeDataService.update(new Recipe(parameter));
            return new Response();
        } catch (NotExistException e) {
            return new Response(500,e.getMessage());
        }
    }

    @Override
    public Response delete(long id){
        try {
            recipeDataService.delete(id);
            return new Response();
        } catch (NotExistException e) {
            return new Response(500,e.getMessage());
        }
    }

    @Override
    public RecipeListResponse findCollectionRecipeByUserId(long userId) {
        List<RecipeCollection> collections=(recipeCollectionDataService.findByUserId(userId));
        List<Recipe> recipes=new ArrayList<>();
        collections.forEach(collection->recipes.add(collection.getRecipe()));
        return new RecipeListResponse(recipes);
    }

    @Override
    public AddResponse collect(long userId, long recipeId){
        try {
            recipeCollectionDataService.findByUserIdAndRecipeId(userId,recipeId);
            return new AddResponse(500,"Already exist!");
        } catch (NotExistException e) {
            RecipeCollection collection=new RecipeCollection();
            collection.setUserId(userId);
            Recipe recipe= null;
            try {
                recipe = recipeDataService.findById(recipeId);
            } catch (NotExistException e1) {
                return new AddResponse(500,e1.getMessage());
            }
            collection.setRecipe(recipe);
            return new AddResponse(recipeCollectionDataService.add(collection));
        }
    }

    @Override
    public Response deleteCollection(long userId, long recipeId){
        try {
            recipeCollectionDataService.deleteByUserIdAndRecipeId(userId,recipeId);
            return new Response();
        } catch (NotExistException e) {
            return new Response(500,e.getMessage());
        }
    }

    @Override
    public RecipeClassificationCountResponse countByRecipeClassification() {
        List list = recipeDataService.countByClassification();
        List<RecipeClassificationCountItem> items = new ArrayList<>();
        for(Object row:list){
            RecipeClassificationCountItem item = new RecipeClassificationCountItem();
            Object[] cells = (Object[]) row;
            item.setClassification((RecipeClassification.values()[(int)cells[0]]));
            item.setCount(((BigInteger) cells[1]).intValue());
            items.add(item);
        }
        return new RecipeClassificationCountResponse(items);
    }

    @Override
    public BooleanResponse isUserCollectRecipe(long userId, long recipeId) {
        try {
            recipeCollectionDataService.findByUserIdAndRecipeId(userId,recipeId);
            return new BooleanResponse(true);
        } catch (NotExistException e) {
            return new BooleanResponse(false);
        }
    }

    @Override
    public RecipeListResponse getAll(int page, int pageSize) {
        Pageable pageable=PageRequest.of(page,pageSize);
        return new RecipeListResponse(recipeDataService.getAll(pageable));
    }

    @Override
    public RecipeListResponse findByName(String name, int page, int pageSize) {
        Pageable pageable=PageRequest.of(page,pageSize);
        return new RecipeListResponse(recipeDataService.findByName(name,pageable));
    }
}
