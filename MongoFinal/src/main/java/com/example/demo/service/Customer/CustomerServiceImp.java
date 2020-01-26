package com.example.demo.service.Customer;

import com.example.demo.dto.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(UUID custId) throws IncorrectResultSizeDataAccessException {
        return customerRepository.findById(custId);
    }

    @Override
    public void addCustomer(Customer cust) {
        UUID customerId = UUID.randomUUID();
        customerRepository.save(new Customer(customerId, cust.getName(), cust.getEligibleToDrive(), cust.getUniqueIdentifier()));
    }

    @Override
    public void updateCustomer(Customer cust, UUID custId) {
        customerRepository.save(cust);
    }

    @Override
    public void deleteCustomer(UUID custId) {
        customerRepository.deleteById(custId);
    }

    @Override
    public Boolean customerExists(String uniqueIdentifier) {
        if (customerRepository.getCustomerByUnId(uniqueIdentifier).isPresent()){
            return true;
        }
        return false;
    }
}
