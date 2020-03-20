package com.hs.diet.response;

import com.hs.diet.entity.Food;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class FoodListResponse extends Response {
    private List<FoodDetailItem> items;
    public FoodListResponse(List<Food> foods) {
        this.items = new ArrayList<>();
        for (Food food : foods) {
            items.add(new FoodDetailItem(food));
        }
    }
}
