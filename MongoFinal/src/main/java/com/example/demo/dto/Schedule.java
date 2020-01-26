package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Document(collection = "masterBookingLog")
public class Schedule {
    @Id
    private UUID scheduleId;
    private Date bookingStDate;
    private Date bookingEndDate;
    private String custUniqueIdentifier;
    private String custName;
    private Boolean eligibleToDrive;
    private String plateNo;
    private String vehicleColor;
    private String vehicleModel;
    @NotNull
    private int type;

    public int getType() {
        return type;
    }

    public Schedule(UUID scheduleId, Date bookingStDate, Date bookingEndDate, String custUniqueIdentifier, String custName, String plateNo, String vehicleColor, String vehicleModel, Boolean eligibleToDrive, int type) {
        this.scheduleId = scheduleId;
        this.bookingStDate = bookingStDate;
        this.bookingEndDate = bookingEndDate;
        this.custUniqueIdentifier = custUniqueIdentifier;
        this.custName = custName;
        this.plateNo = plateNo;
        this.vehicleColor = vehicleColor;
        this.vehicleModel = vehicleModel;
        this.eligibleToDrive = eligibleToDrive;
        this.type = type;
    }


    public String getCustUniqueIdentifier() {
        return custUniqueIdentifier;
    }

    public void setCustUniqueIdentifier(String custUniqueIdentifier) {
        this.custUniqueIdentifier = custUniqueIdentifier;
    }

    public Boolean getEligibleToDrive() {
        return eligibleToDrive;
    }

    public void setEligibleToDrive(Boolean eligibleToDrive) {
        this.eligibleToDrive = eligibleToDrive;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setBookingStDate(Date bookingStDate) {
        this.bookingStDate = bookingStDate;
    }

    public void setBookingEndDate(Date bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public UUID getScheduleId() {
        return scheduleId;
    }

    public Date getBookingStDate() {
        return bookingStDate;
    }

    public Date getBookingEndDate() {
        return bookingEndDate;
    }


}

