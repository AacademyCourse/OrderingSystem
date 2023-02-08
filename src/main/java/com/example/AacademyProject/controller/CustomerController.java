package com.example.AacademyProject.controller;

import com.example.AacademyProject.entity.Customer;
import com.example.AacademyProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(path = "/{id}")
    Customer getUser(@PathVariable Long id){
        Customer customerResult = new Customer();
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerResult =  customer.get();
        }
        return customerResult;
    }
}
