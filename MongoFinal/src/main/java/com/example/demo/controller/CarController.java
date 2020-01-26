package com.example.demo.controller;

import com.example.demo.dto.Car;
import com.example.demo.service.Car.CarService;
import com.example.demo.service.Car.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CarController {

    @Autowired
    CarServiceImp carServiceImp;

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carServiceImp.getAllCars();
    }

    @GetMapping("/cars/{carId}")
    public Optional<Car> getCarById(@PathVariable UUID carId) {
        return carServiceImp.getCarById(carId);
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car) throws IncorrectResultSizeDataAccessException {
        carServiceImp.addCar(car);
    }

    @PutMapping("/cars/{carId}")
    public void updateCar(@RequestBody Car car, @PathVariable UUID carId) {
        carServiceImp.updateCar(carId, car);
    }

    @DeleteMapping("/cars/{carId}")
    public void deleteCar(@PathVariable UUID carId) {
        carServiceImp.deleteCar(carId);
    }

}
