package com.ht.diet.dataServiceImpl;

import com.ht.diet.dao.RecipeDao;
import com.ht.diet.dataService.RecipeDataService;
import com.ht.diet.entity.Recipe;
import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeDataServiceImpl implements RecipeDataService {
    @Autowired
    private RecipeDao recipeDao;
    @Override
    public Recipe findById(long id) throws NotExistException {
        Optional<Recipe> optional=recipeDao.findByIdAndIsValid(id,1);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw new NotExistException("Recipe ID",id);
        }
    }

    @Override
    public List<Recipe> findByClassification(RecipeClassification classification, Pageable pageable) {
        return recipeDao.findByClassificationAndIsValid(classification.ordinal(),1,pageable);
    }

    @Override
    public long add(Recipe recipe) {
        return recipeDao.save(recipe).getId();
    }

    @Override
    public void update(Recipe recipe) throws NotExistException {
        Optional<Recipe> optional=recipeDao.findByIdAndIsValid(recipe.getId(),1);
        if(optional.isPresent()){
            recipeDao.save(recipe);
        }
        else{
            throw new NotExistException("Recipe ID",recipe.getId());
        }
    }

    @Override
    public void delete(long id) throws NotExistException {
        Optional<Recipe> optional=recipeDao.findByIdAndIsValid(id,1);
        if(optional.isPresent()){
            Recipe recipe=optional.get();
            recipe.setIsValid(0);
            recipeDao.save(recipe);
        }
        else{
            throw new NotExistException("Recipe ID",id);
        }
    }

    @Override
    public List countByClassification() {
        return recipeDao.countByClassification();
    }

    @Override
    public List<Recipe> getAll(Pageable pageable) {
        return recipeDao.getAll(pageable);
    }

    @Override
    public List<Recipe> findByName(String name, Pageable pageable) {
        return recipeDao.findByName(name,pageable);
    }
}
