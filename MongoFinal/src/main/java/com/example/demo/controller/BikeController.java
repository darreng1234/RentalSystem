package com.example.demo.controller;

import com.example.demo.dto.Bike;
import com.example.demo.service.Bike.BikeService;
import com.example.demo.service.Bike.BikeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BikeController {

    @Autowired
    BikeServiceImp bikeService;

    @GetMapping("/bikes")
    public List<Bike> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @PostMapping("/bikes")
    public void addBike(@RequestBody Bike bike) throws IncorrectResultSizeDataAccessException {
        bikeService.addBike(bike);
    }

    @PutMapping("/bikes/{bikeId}")
    public void updateBike(@RequestBody Bike bike, @PathVariable UUID bikeId) {
        bikeService.updateBike(bikeId, bike);
    }

    @GetMapping("bikes/{bikeId}")
    public Optional<Bike> getBikeById(@PathVariable UUID bikeId) {
        return bikeService.getBikeById(bikeId);
    }

    @DeleteMapping("bikes/{bikeId}")
    public void deleteCarById(@PathVariable UUID bikeId) {
        bikeService.deleteBike(bikeId);
    }


}
