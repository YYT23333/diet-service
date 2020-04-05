package com.hs.diet.response;

import com.hs.diet.entity.Recipe;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
public class RecipeDetailResponse extends Response {
    @ApiModelProperty("返回数据")
    private RecipeDetailItem data;
    public RecipeDetailResponse(Recipe recipe){
        this.code = "200";
        this.msg = "操作成功！";
        this.data=new RecipeDetailItem(recipe);
    }
}
