package com.hs.diet.dataServiceImpl;

import com.hs.diet.dao.RecipeDao;
import com.hs.diet.dataService.RecipeDataService;
import com.hs.diet.entity.Recipe;
import com.hs.diet.enums.RecipeClassification;
import com.hs.diet.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeDataServiceImpl implements RecipeDataService {
    @Autowired
    private RecipeDao recipeDao;
    @Override
    public Recipe findById(Long id) throws NotExistException {
        Optional<Recipe> optional=recipeDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw new NotExistException("Recipe ID",id);
        }
    }

    @Override
    public List<Recipe> findByClassification(RecipeClassification classification) {
        return recipeDao.findByClassification(classification);
    }
}
