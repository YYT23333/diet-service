package com.ht.diet.dao;

import com.ht.diet.entity.DietRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DietRecordDao extends JpaRepository<DietRecord,String> {
    Optional<DietRecord> findById(long id);
    @Query(nativeQuery = true, value = "select * from diet_record where user_id=?1 and time>=?2 order by time asc ")
    List<DietRecord> findByUserIdAndTime(long userId,LocalDateTime time);
}
