package com.example.demo.service.Bike;

import com.example.demo.dto.Bike;
import com.example.demo.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BikeServiceImp implements BikeService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BikeRepository bikeRepository;

    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public Optional<Bike> getBikeById(UUID bikeId) {
        return bikeRepository.findById(bikeId);
    }

    @Override
    public void addBike(Bike bike) {
        UUID bikeId = UUID.randomUUID();
        bikeRepository.save(new Bike(bikeId, bike.getModel(), bike.getColor(), bike.getPlateNo(), bike.getHeadGearIncnclusive(), bike.getStorageSpace(), bike.getType(), "F"));
    }

    @Override
    public void updateBike(UUID bikeId, Bike bike) {
        bikeRepository.save(bike);
    }

    @Override
    public void deleteBike(UUID bikeId) {
        bikeRepository.deleteById(bikeId);
    }

    @Override
    public void updateStatus(String plateNo) {
        Query query = new Query(Criteria.where("plateNo").is(plateNo));
        Update update = new Update();
        update.set("status","A");
        mongoTemplate.updateFirst(query,update, Bike.class);
    }

    public Optional<Bike> getBikeByPlateNo(String plateNo){
        return bikeRepository.getBikeByPlateNo(plateNo);
    }
}
