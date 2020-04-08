package com.ht.diet.serviceImpl;

import com.ht.diet.dataService.DietRecordDataService;
import com.ht.diet.entity.DietRecord;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.parameters.DietRecordParameter;
import com.ht.diet.response.AddResponse;
import com.ht.diet.response.DietRecordDetailResponse;
import com.ht.diet.response.DietRecordListResponse;
import com.ht.diet.service.DietRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietRecordServiceImpl implements DietRecordService {
    @Autowired
    private DietRecordDataService dietRecordDataService;
    @Override
    public DietRecordDetailResponse findById(long id) throws NotExistException {
        return new DietRecordDetailResponse(dietRecordDataService.findById(id));
    }

    @Override
    public DietRecordListResponse findByUser(long userId) {
        return new DietRecordListResponse(dietRecordDataService.findByUserId(userId));
    }

    @Override
    public AddResponse add(DietRecordParameter parameter) {
        DietRecord record=new DietRecord(parameter);
        return new AddResponse(dietRecordDataService.add(record));
    }
}
