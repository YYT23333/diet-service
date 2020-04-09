package com.ht.diet.response;

import com.ht.diet.entity.Food;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel
public class FoodListResponse extends Response {
    @ApiModelProperty("返回数据")
    private List<FoodDetailItem> data;
    public FoodListResponse(List<Food> foods) {
        this.code = 200;
        this.msg = "操作成功！";
        this.data = new ArrayList<>();
        for (Food food : foods) {
            ((ArrayList) this.data).add(new FoodDetailItem(food));
        }
    }
}
