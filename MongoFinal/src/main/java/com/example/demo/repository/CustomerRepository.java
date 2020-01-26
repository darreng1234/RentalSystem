package com.example.demo.repository;

import com.example.demo.dto.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, UUID> {

    @Query("{'uniqueIdentifier' : ?0 }")
    Optional<Customer> getCustomerByUnId(String uniqueIdentifier);
}
