package com.ht.diet.dataServiceImpl;

import com.ht.diet.dao.RecipeCollectionDao;
import com.ht.diet.dataService.RecipeCollectionDataService;
import com.ht.diet.entity.Recipe;
import com.ht.diet.entity.RecipeCollection;
import com.ht.diet.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeCollectionDataServiceImpl implements RecipeCollectionDataService {
    @Autowired
    private RecipeCollectionDao recipeCollectionDao;
    @Override
    public List<RecipeCollection> findByUserId(long userId) {
        return recipeCollectionDao.findByUserId(userId);
    }

    @Override
    public RecipeCollection findByUserIdAndRecipeId(long userId, long recipeId) throws NotExistException {
        Optional<RecipeCollection> optional=recipeCollectionDao.findByUserIdAndRecipeId(userId,recipeId);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw new NotExistException("RecipeCollection with this recipe and userId：",userId);
        }
    }

    @Override
    public long add(RecipeCollection collection) {
       return recipeCollectionDao.save(collection).getId();
    }

    @Override
    public void deleteByUserIdAndRecipeId(long userId,long recipeId) throws NotExistException {
        Optional<RecipeCollection> optional=recipeCollectionDao.findByUserIdAndRecipeId(userId,recipeId);
        if(optional.isPresent()){
            recipeCollectionDao.delete(optional.get());
        }
        else{
            throw new NotExistException("RecipeCollection with this recipe and userId：",userId);
        }
    }
}
