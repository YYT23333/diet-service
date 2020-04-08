package com.ht.diet.response;

import com.ht.diet.entity.DietItem;
import com.ht.diet.entity.DietRecord;
import com.ht.diet.enums.DietRecordType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel
public class DietRecordItem {
    @ApiModelProperty("饮食记录id")
    private long id;

    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("创建时间")
    private LocalDateTime time;

    @ApiModelProperty("饮食记录类型")
    private DietRecordType type;

    @ApiModelProperty("卡路里")
    private double calories;

    @ApiModelProperty("饮食记录内容")
    private List<DietItem> dietItems;

    public DietRecordItem(DietRecord record){
        this.id=record.getId();
        this.userId=record.getUserId();
        this.time=record.getTime();
        this.type=record.getType();
        this.calories=record.getCalories();
        this.dietItems=record.getDietItems();
    }
}