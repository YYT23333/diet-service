package com.hs.diet.serviceImpl;

import com.hs.diet.dataService.DietRecordDataService;
import com.hs.diet.entity.DietRecord;
import com.hs.diet.exception.NotExistException;
import com.hs.diet.parameters.DietRecordParameter;
import com.hs.diet.response.AddResponse;
import com.hs.diet.response.DietRecordDetailResponse;
import com.hs.diet.response.DietRecordListResponse;
import com.hs.diet.service.DietRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietRecordServiceImpl implements DietRecordService {
    @Autowired
    private DietRecordDataService dietRecordDataService;
    @Override
    public DietRecordDetailResponse findById(Long id) throws NotExistException {
        return new DietRecordDetailResponse(dietRecordDataService.findById(id));
    }

    @Override
    public DietRecordListResponse findByUser(Long userId) {
        return new DietRecordListResponse(dietRecordDataService.findByUserId(userId));
    }

    @Override
    public AddResponse add(DietRecordParameter parameter) {
        DietRecord record=new DietRecord();
        record.setUserId(parameter.getUserId());
        record.setCalories(parameter.getCalories());
        record.setDietItems(parameter.getDietItems());
        record.setTime(parameter.getTime());
        record.setType(parameter.getType());
        return new AddResponse(dietRecordDataService.add(record));
    }
}
