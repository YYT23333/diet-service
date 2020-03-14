package com.hs.diet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="pic",nullable = false)
    private String pic;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="price",nullable = false)
    private double price;


}

