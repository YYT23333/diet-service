package com.ht.diet.entity;

import com.ht.diet.enums.DietRecordType;
import com.ht.diet.parameters.DietRecordParameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietRecord {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long userId;

    @Column
    private LocalDateTime time;

    @Column
    private DietRecordType type;

    @Column
    private double calories;

    @ElementCollection
    private List<DietItem> dietItems;

    public DietRecord(DietRecordParameter parameter){
        this.userId=parameter.getUserId();
        this.time=parameter.getTime();
        this.type=parameter.getType();
        this.calories=parameter.getCalories();
        this.dietItems=parameter.getDietItems();
    }
}
