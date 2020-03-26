package com.hs.diet.response;

import com.hs.diet.entity.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDetailResponse extends Response {
    private RecipeDetailItem item;
    public RecipeDetailResponse(Recipe recipe){
        this.item=new RecipeDetailItem(recipe);
    }
}
