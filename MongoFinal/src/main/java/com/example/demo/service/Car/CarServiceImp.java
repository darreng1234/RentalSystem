package com.example.demo.service.Car;

import com.example.demo.dto.Car;
import com.example.demo.repository.CarRepository;
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
public class CarServiceImp implements CarService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(UUID carId) {
        return carRepository.findById(carId);
    }

    @Override
    public int addCar(Car car) {
        UUID carId = UUID.randomUUID();
        String status = "F";
        carRepository.save(new Car(carId, car.getModel(), car.getPlateNo(), car.getColor(), car.getMaxPassengers(), car.isAirConditioned(), car.getTransmission(), car.getType(), "F"));
        return 0;
    }


    @Override
    public void updateCar(UUID carId, Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(UUID carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public void updateStatus(String plateNo){
        Query query = new Query(Criteria.where("plateNo").is(plateNo));
        Update update = new Update();
        update.set("status","A");
        mongoTemplate.updateFirst(query,update,Car.class);
    }

    public Optional<Car> getCarByPlateNo(String plateNo){
        return carRepository.getCarByPlateNo(plateNo);
    }


}
