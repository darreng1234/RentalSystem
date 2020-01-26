package com.example.demo.controller;

import com.example.demo.dto.Customer;
import com.example.demo.service.Customer.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
    @Autowired
    CustomerServiceImp service;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomer();
    }

    @RequestMapping("/customers/{custId}")
    public Optional<Customer> getCustomerById(@PathVariable UUID custId) {
        return service.getCustomerById(custId);
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer cust) throws IncorrectResultSizeDataAccessException {
        service.addCustomer(cust);
    }

    @PutMapping("/customers/{custId}")
    public void updateCustomer(@RequestBody Customer cust, @PathVariable UUID custId) {
        service.updateCustomer(cust, custId);
    }

    @DeleteMapping("/customers/{custId}")
    public void deleteCustomer(@PathVariable UUID custId) {
        service.deleteCustomer(custId);
    }

    


}
