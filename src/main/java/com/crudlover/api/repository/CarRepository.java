package com.crudlover.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudlover.api.model.CarModel;

public interface CarRepository extends JpaRepository<CarModel, Long> {
    
}