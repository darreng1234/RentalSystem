package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.UUID;

@Document(collection = "car")
public class Car extends Vehicle {
    @Id
    private UUID carId;
    private Boolean airConditioned;
    private String transmission;
    private int type = 1;
    private int seatCapacity;

    public Car(UUID carId, String model, String plateNo, String color, int seatCapacity, Boolean airConditioned, String transmission, int type, String status) {
        super(model, color, plateNo,status);
        this.seatCapacity = seatCapacity;
        this.carId = carId;
        this.airConditioned = airConditioned;
        this.transmission = transmission;
        this.type = type;
    }

    public UUID getCarId() {
        return carId;
    }

    public int getMaxPassengers() {
        return seatCapacity;
    }

    public Boolean isAirConditioned() {
        return airConditioned;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setAirConditioned(Boolean airConditioned) {
        this.airConditioned = airConditioned;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getType() {
        return 1;
    }


}
