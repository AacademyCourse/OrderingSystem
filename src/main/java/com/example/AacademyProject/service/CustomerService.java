package com.example.AacademyProject.service;

import com.example.AacademyProject.entity.Customer;
import com.example.AacademyProject.exception.UserNotFoundException;
import com.example.AacademyProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Customer findById(Long id) throws UserNotFoundException {
        Optional<Customer> customer;
        customer = this.customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }else{
            throw new UserNotFoundException(String.format("User with %s id not found",id));
        }
    }

    public Customer saveCustomer(Customer customer){
         customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
         return this.customerRepository.save(customer);
    }
}
