package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}
