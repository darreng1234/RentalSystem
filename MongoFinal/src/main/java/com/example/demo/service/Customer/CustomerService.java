package com.example.demo.service.Customer;

import com.example.demo.dto.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomer();

    Optional<Customer> getCustomerById(UUID custId);

    void addCustomer(Customer cust);

    void updateCustomer(Customer cust, UUID custId);

    void deleteCustomer(UUID custId);

    Boolean customerExists(String uniqueIdentifier);
}
