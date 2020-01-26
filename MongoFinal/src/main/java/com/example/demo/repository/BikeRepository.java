package com.example.demo.repository;

import com.example.demo.dto.Bike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BikeRepository extends MongoRepository<Bike, UUID> {

    @Query("{'plateNo' : ?0 }")
    Optional<Bike> getBikeByPlateNo(String plateNo);
}
