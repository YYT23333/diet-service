package com.ht.diet.service;

import com.ht.diet.parameters.DietRecordParameter;
import com.ht.diet.response.AddResponse;
import com.ht.diet.response.DietRecordDetailListResponse;
import com.ht.diet.response.DietRecordDetailResponse;
import com.ht.diet.response.DietRecordListResponse;

public interface DietRecordService {
    DietRecordDetailResponse findById(long id);
    DietRecordListResponse getThisWeek(long userId);
    DietRecordDetailListResponse getToday(long userId);
    AddResponse add(DietRecordParameter parameter);
}