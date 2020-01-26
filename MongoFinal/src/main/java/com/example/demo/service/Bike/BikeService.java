package com.example.demo.service.Bike;

import com.example.demo.dto.Bike;

import java.util.List;
import java.util.Optional;
import java.util.UUID;;

public interface BikeService {

    List<Bike> getAllBikes();

    Optional<Bike> getBikeById(UUID bikeId);

    void addBike(Bike bike);

    void updateBike(UUID bikeId, Bike bike);

    void deleteBike(UUID bikeId);

    void updateStatus(String plateNo);
}

