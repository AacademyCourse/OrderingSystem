package com.example.AacademyProject.runner;

import com.example.AacademyProject.entity.Customer;
import com.example.AacademyProject.entity.Email;
import com.example.AacademyProject.entity.Order;
import com.example.AacademyProject.repository.CustomerRepository;
import com.example.AacademyProject.repository.EmailRepository;
import com.example.AacademyProject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmailRepository emailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setCustomerName("Pesho");
        customer.setCustomerLastName("Nikolov");
        Email email = new Email();
        email.setEmailAddress("example@google.com");
        Email savedEmail = emailRepository.save(email);
        customer.setCustomerEmail(savedEmail);
        Customer savedCustomer = customerRepository.save(customer);

        Order order = new Order();
        order.setProducts("Potato,Tomato,Onion");
        order.setCustomer(savedCustomer);
        orderRepository.save(order);

        System.out.println("CUSTOMER SAVED");

    }
}
