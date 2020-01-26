package com.example.demo.service.Car;

import com.example.demo.dto.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarService {

    int addCar(Car car);

    List<Car> getAllCars();

    Optional<Car> getCarById(UUID carId);

    void updateCar(UUID carId, Car car);

    void deleteCar(UUID carId);

    void updateStatus(String plateNo);
}
