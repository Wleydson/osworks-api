package com.wleydsonlemos.osworksapi.api.controller;

import com.wleydsonlemos.osworksapi.domain.model.OrderService;
import com.wleydsonlemos.osworksapi.domain.service.OrderServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    @Autowired
    private OrderServiceService orderServiceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderService insert(@Valid @RequestBody OrderService orderService){
        return orderServiceService.insert(orderService);
    }
}
