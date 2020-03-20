package com.hs.diet.response;

import com.hs.diet.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDetailResponse extends Response{
    private FoodDetailItem item;
    public FoodDetailResponse(Food food){
        this.item=new FoodDetailItem(food);
    }
}
