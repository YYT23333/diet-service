package com.ht.diet.dataServiceImpl;

import com.ht.diet.dao.DietRecordDao;
import com.ht.diet.dataService.DietRecordDataService;
import com.ht.diet.entity.DietRecord;
import com.ht.diet.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DietRecordDataServiceImpl implements DietRecordDataService {
    @Autowired
    private DietRecordDao dietRecordDao;
    @Override
    public DietRecord findById(long id) throws NotExistException {
        Optional<DietRecord> optional=dietRecordDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw new NotExistException("DietRecord ID",id);
        }
    }

    @Override
    public List<DietRecord> findByUserIdAndTime(long userId, LocalDateTime time) {
        return dietRecordDao.findByUserIdAndTime(userId,time);
    }

    @Override
    public Long add(DietRecord record) {
        return dietRecordDao.save(record).getId();
    }
}
