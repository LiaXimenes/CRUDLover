package com.crudlover.api.model;


import com.crudlover.api.DTO.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CarModel {

    public CarModel(CarDTO data){
        this.model = data.model();
        this.manufacturer = data.manufacturer();
        this.date = data.date();
        this.price = data.price();
        this.year = data.year();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String model;

    @Column(length = 50, nullable = false)
    private String manufacturer;

    @Column(length = 12, nullable = false)
    private String date;

    @Column(length = 10, nullable = false)
    private double price;

    @Column(length = 4, nullable = false)
    private int year;
    
}