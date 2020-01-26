package com.example.demo.repository;

import com.example.demo.dto.Car;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends MongoRepository<Car, UUID> {

    @Query("{'plateNo' : ?0 }")
    Optional<Car> getCarByPlateNo(String plateNo);



}
