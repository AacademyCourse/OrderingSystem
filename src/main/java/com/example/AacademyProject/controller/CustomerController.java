package com.example.AacademyProject.controller;

import com.example.AacademyProject.entity.Customer;
import com.example.AacademyProject.entity.Email;
import com.example.AacademyProject.exception.UserNotFoundException;
import com.example.AacademyProject.model.CustomerRequest;
import com.example.AacademyProject.repository.CustomerRepository;
import com.example.AacademyProject.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import javax.print.attribute.standard.Media;
import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(path = "/{id}")
    Customer getUser(@PathVariable Long id,@RequestParam String name) throws UserNotFoundException {
        return customerService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,path = "/create")
    Customer saveCustomer(@Valid @RequestBody CustomerRequest customerRequest){

        Customer customer = customerRequest.convert();
         return customerService.saveCustomer(customer);
    }



}
