package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "customer")
public class Customer {
    @Id
    private UUID customerId;
    private String name;
    private Boolean eligibleToDrive;
    private String uniqueIdentifier; //This can be Passport/NIC or any other unique identification

    public Customer(UUID customerId, String name, Boolean eligibleToDrive, String uniqueIdentifier) {
        this.customerId = customerId;
        this.name = name;
        this.eligibleToDrive = eligibleToDrive;
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEligibleToDrive() {
        return eligibleToDrive;
    }

    public void setEligibleToDrive(Boolean eligibleToDrive) {
        this.eligibleToDrive = eligibleToDrive;
    }


}
