package com.ht.diet.serviceImpl;

import com.ht.diet.dataService.DietRecordDataService;
import com.ht.diet.entity.DietRecord;
import com.ht.diet.enums.DietRecordType;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.parameters.DietRecordParameter;
import com.ht.diet.response.*;
import com.ht.diet.service.DietRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DietRecordServiceImpl implements DietRecordService {
    @Autowired
    private DietRecordDataService dietRecordDataService;

    @Override
    public DietRecordDetailResponse findById(long id) {
        try {
            return new DietRecordDetailResponse(dietRecordDataService.findById(id));
        } catch (NotExistException e) {
            return new DietRecordDetailResponse(500, e.getMessage());
        }
    }

    @Override
    public DietRecordListResponse getThisWeek(long userId) {
        LocalDateTime week_start = LocalDateTime.of(LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 1), LocalTime.MIN);
        List<DietRecord> records = dietRecordDataService.findByUserIdAndTime(userId, week_start);
        if(records==null ||  records.size()<1){
            List<DietRecordListItem> listItems=new ArrayList<>();
            for(DayOfWeek dayOfWeek:DayOfWeek.values()){
                DietRecordListItem listItem=new DietRecordListItem();
                listItem.setDayOfWeek(dayOfWeek.getValue());
                listItem.setCalories(0);
                List<DietRecordListItemDetailItem> detailItems=new ArrayList<>();
                for(DietRecordType type:DietRecordType.values()){
                    DietRecordListItemDetailItem detailItem=new DietRecordListItemDetailItem();
                    detailItem.setType(type);
                    detailItem.setCalories(0);
                    detailItem.setDietRecordId(0);
                    detailItems.add(detailItem);
                }
                listItem.setRecords(detailItems);
                listItems.add(listItem);
            }
            return new DietRecordListResponse(listItems);
        }
        Map<Integer,List<DietRecord>> map = new HashMap<>();
        records.forEach(record -> {
            int dayOfWeek = record.getTime().getDayOfWeek().getValue();
            List<DietRecord> list = map.get(dayOfWeek);
            if(list==null || list.size()<1){
                list=new ArrayList<>();
            }
            list.add(record);
            map.put(dayOfWeek, list);
        });
        List<DietRecordListItem> listItems = new ArrayList<>();
        map.forEach((k, v) -> {
            DietRecordListItem listItem=new DietRecordListItem();
            listItem.setDayOfWeek(k);
            listItem.setCalories(0);
            List<DietRecordListItemDetailItem> detailItems = new ArrayList<>();
            List<DietRecordType> hasTypes = new ArrayList<>();
            v.forEach(record -> {
                hasTypes.add(record.getType());
                DietRecordListItemDetailItem detailItem = new DietRecordListItemDetailItem();
                detailItem.setCalories(record.getCalories());
                detailItem.setType(record.getType());
                detailItem.setDietRecordId(record.getId());
                listItem.setCalories(listItem.getCalories()+detailItem.getCalories());
                detailItems.add(detailItem);
            });
            for (DietRecordType type : DietRecordType.values()) {
                if (!hasTypes.contains(type)) {
                    DietRecordListItemDetailItem detailItem = new DietRecordListItemDetailItem();
                    detailItem.setCalories(0);
                    detailItem.setType(type);
                    detailItem.setDietRecordId(0);
                    detailItems.add(detailItem);
                }
            }
            listItem.setRecords(detailItems);
            listItems.add(listItem);
        });
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (!map.containsKey(dayOfWeek.getValue())) {
                DietRecordListItem listItem=new DietRecordListItem();
                listItem.setCalories(0);
                listItem.setDayOfWeek(dayOfWeek.getValue());
                List<DietRecordListItemDetailItem> detailItems = new ArrayList<>();
                for (DietRecordType type : DietRecordType.values()) {
                    DietRecordListItemDetailItem item = new DietRecordListItemDetailItem();
                    item.setDietRecordId(0);
                    item.setType(type);
                    item.setCalories(0);
                    detailItems.add(item);
                }
                listItem.setRecords(detailItems);
                listItems.add(listItem);
            }
        }
        return new DietRecordListResponse(listItems);
    }

    @Override
    public DietRecordDetailListResponse getToday(long userId) {
        LocalDateTime today=LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
        return new DietRecordDetailListResponse(dietRecordDataService.findByUserIdAndTime(userId,today));
    }

    @Override
    public AddResponse add(DietRecordParameter parameter) {
        DietRecord record = new DietRecord(parameter);
        record.setTime(LocalDateTime.now());
        return new AddResponse(dietRecordDataService.add(record));
    }
}
