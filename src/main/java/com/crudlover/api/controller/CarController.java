package com.crudlover.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.api.DTO.CarDTO;
import com.crudlover.api.model.CarModel;
import com.crudlover.api.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<CarModel> carList(){
        return repository.findAll();
    }

    @PostMapping
    public void createCar(@RequestBody @Valid CarDTO req){
        repository.save(new CarModel(req));
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody @Valid CarDTO req){
        repository.findById(id).map(car -> {
            car.setModel(req.model());
            car.setManufacturer(req.manufacturer());
            car.setDate(req.date());
            car.setPrice(req.price());
            car.setYear(req.year());
            
            return repository.save(car);
        });
    }
}