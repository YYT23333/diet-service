package com.hs.diet.response;

import com.hs.diet.entity.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class RecipeListResponse extends Response {
    private List<RecipeDetailItem> items;
    public RecipeListResponse(List<Recipe> recipes){
        this.items=new ArrayList<>();
        for (Recipe recipe:recipes) {
            items.add(new RecipeDetailItem(recipe));
        }
    }
}
