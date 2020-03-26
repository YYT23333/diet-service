package com.hs.diet.parameters;

import com.hs.diet.entity.DietItem;
import com.hs.diet.entity.Ingredient;
import com.hs.diet.entity.Step;
import com.hs.diet.enums.DietRecordType;
import com.hs.diet.enums.RecipeClassification;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class DietRecordParameter {
    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("创建时间")
    private LocalDateTime time;

    @ApiModelProperty("饮食记录类型")
    private DietRecordType type;

    @ApiModelProperty("卡路里")
    private double calories;

    @ApiModelProperty("饮食记录内容")
    private List<DietItem> dietItems;
}
