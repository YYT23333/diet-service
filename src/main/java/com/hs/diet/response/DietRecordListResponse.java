package com.hs.diet.response;

import com.hs.diet.entity.DietRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel
public class DietRecordListResponse extends Response {
    @ApiModelProperty("返回数据")
    private List<DietRecordItem> data;
    public DietRecordListResponse(List<DietRecord> records){
        this.code = "200";
        this.msg = "操作成功！";
        this.data=new ArrayList<>();
        for (DietRecord record:records) {
            ((ArrayList) this.data).add(new DietRecordItem(record));
        }
    }
}
