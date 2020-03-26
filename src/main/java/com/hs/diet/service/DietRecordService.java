package com.hs.diet.service;

import com.hs.diet.exception.NotExistException;
import com.hs.diet.parameters.DietRecordParameter;
import com.hs.diet.response.AddResponse;
import com.hs.diet.response.DietRecordDetailResponse;
import com.hs.diet.response.DietRecordListResponse;

public interface DietRecordService {
    DietRecordDetailResponse findById(Long id)throws NotExistException;
    DietRecordListResponse findByUser(Long userId);
    AddResponse add(DietRecordParameter parameter);
}
