package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "bike")
public class Bike extends Vehicle {
    @Id
    private UUID bikeId;
    private Boolean headGearIncnclusive;
    private Boolean storageSpace;
    private int type = 2;

    public UUID getBikeId() {
        return bikeId;
    }


    public Bike(UUID bikeId, String model, String color, String plateNo, Boolean headGearIncnclusive, Boolean storageSpace, int type, String status) {
        super(model, color, plateNo,status);
        this.bikeId = bikeId;
        this.headGearIncnclusive = headGearIncnclusive;
        this.storageSpace = storageSpace;
        this.type = type;
    }


    public Boolean getHeadGearIncnclusive() {
        return headGearIncnclusive;
    }

    public void setHeadGearIncnclusive(Boolean headGearIncnclusive) {
        this.headGearIncnclusive = headGearIncnclusive;
    }

    public Boolean getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(Boolean storageSpace) {
        this.storageSpace = storageSpace;
    }

    public int getMaxPassengers() {
        return 2;
    }

    public int getType() {
        return 2;
    }


}
