package com.example.AacademyProject.controller;

import com.example.AacademyProject.entity.Order;
import com.example.AacademyProject.exception.UserNotFoundException;
import com.example.AacademyProject.service.OrderService;
import com.example.AacademyProject.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping(path="/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    Order createOrder(@RequestBody Order order, @RequestParam Long user_id) throws UserNotFoundException {
        return orderService.createOrder(order,user_id);
    }
}
