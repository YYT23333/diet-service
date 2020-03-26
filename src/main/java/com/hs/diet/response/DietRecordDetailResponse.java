package com.hs.diet.response;

import com.hs.diet.entity.DietRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietRecordDetailResponse extends Response {
    private DietRecordItem item;
    public DietRecordDetailResponse(DietRecord record){
        this.item=new DietRecordItem(record);
    }
}
