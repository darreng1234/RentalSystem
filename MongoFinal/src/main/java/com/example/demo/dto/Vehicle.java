package com.example.demo.dto;


abstract class Vehicle {

    private String color;
    private String model;
    private String status;
    private String plateNo;

    public Vehicle(String model, String color, String plateNo, String status) {
        this.model = model;
        this.color = color;
        this.plateNo = plateNo;
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract int getMaxPassengers();

}
