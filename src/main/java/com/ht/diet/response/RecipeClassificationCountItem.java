package com.ht.diet.response;

import com.ht.diet.enums.RecipeClassification;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class RecipeClassificationCountItem {
    private RecipeClassification classification;
    private int count;
    
}
