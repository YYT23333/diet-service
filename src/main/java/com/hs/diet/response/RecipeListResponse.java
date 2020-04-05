package com.hs.diet.response;

import com.hs.diet.entity.Recipe;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel
public class RecipeListResponse extends Response {
    @ApiModelProperty("返回数据")
    private List<RecipeDetailItem> data;
    public RecipeListResponse(List<Recipe> recipes){
        this.code = "200";
        this.msg = "操作成功！";
        this.data=new ArrayList<>();
        for (Recipe recipe:recipes) {
            ((ArrayList) this.data).add(new RecipeDetailItem(recipe));
        }
    }
}
