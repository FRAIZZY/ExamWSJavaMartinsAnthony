/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examWSJavaMartinsAnthony.controller;

import com.humanbooster.examWSJavaMartinsAnthony.model.Car;
import com.humanbooster.examWSJavaMartinsAnthony.repository.CarRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author HB
 */
@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("")
    public List<Car> allCar() {

        return this.carRepository.findAll();

    }

    @GetMapping(value = "/{car}", produces = {"application/json"})
    public Car getCar(@PathVariable(name = "car", required = false) Car car) {

        if (car == null) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Voiture introuvable"
            );

        } else {
            return car;
        }

    }
    
    @PostMapping(value = "", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Car> saveCar(@Valid @RequestBody Car car) {
        
        this.carRepository.save(car);
        return new ResponseEntity<Car>(car, HttpStatus.CREATED);
        
    }
}
