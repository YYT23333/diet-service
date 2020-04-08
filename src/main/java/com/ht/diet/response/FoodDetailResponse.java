package com.ht.diet.response;

import com.ht.diet.entity.Food;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FoodDetailResponse extends Response{
    @ApiModelProperty("返回数据")
    private FoodDetailItem data;
    public FoodDetailResponse(Food food){
        this.code = "200";
        this.msg = "操作成功！";
        this.data=new FoodDetailItem(food);
    }
}
