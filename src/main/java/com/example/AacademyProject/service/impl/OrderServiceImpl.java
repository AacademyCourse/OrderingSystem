package com.example.AacademyProject.service.impl;

import com.example.AacademyProject.entity.Customer;
import com.example.AacademyProject.entity.Order;
import com.example.AacademyProject.exception.UserNotFoundException;
import com.example.AacademyProject.repository.OrderRepository;
import com.example.AacademyProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    private final CustomerService customerService;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(CustomerService customerService, OrderRepository orderRepository) {
        this.customerService = customerService;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order orderInfo, Long user_id) throws UserNotFoundException {
        Customer foundCustomer = customerService.findById(user_id);
        orderInfo.setCustomer(foundCustomer);
        return orderRepository.save(orderInfo);
    }
}
