package com.ht.diet.dao;

import com.ht.diet.entity.Recipe;
import com.ht.diet.enums.RecipeClassification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecipeDao extends JpaRepository<Recipe,String> {
    Optional<Recipe> findById(long id);
    Optional<Recipe> findByIdAndIsValid(long id,int isValid);
    @Query(nativeQuery = true,
            value = "select * from recipe where recipe.classification=?1 and recipe.is_valid=?2",
            countQuery = "select * from recipe where recipe.classification=?1 and recipe.is_valid=?2")
    List<Recipe> findByClassificationAndIsValid(int classification, int isValid, Pageable pageable);
    @Query(nativeQuery = true,value = "select classification,count(*) from recipe where is_valid=1 group by classification")
    List countByClassification();
    @Query(nativeQuery = true,
            value = "select * from recipe where recipe.name like %?1%",
            countQuery = "select * from recipe where recipe.name like %?1%")
    List<Recipe> findByName(String name, Pageable pageable);
    @Query(nativeQuery = true,
            value = "select * from recipe",
            countQuery = "select * from")
    List<Recipe> getAll(Pageable pageable);
}
