package com.wleydsonlemos.osworksapi.api.controller;

import com.wleydsonlemos.osworksapi.api.dto.CommentInputDTO;
import com.wleydsonlemos.osworksapi.api.dto.OrderServiceDTO;
import com.wleydsonlemos.osworksapi.api.dto.OrderServiceInputDTO;
import com.wleydsonlemos.osworksapi.domain.model.OrderService;
import com.wleydsonlemos.osworksapi.domain.service.OrderServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    @Autowired
    private OrderServiceService orderServiceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderServiceDTO insert(@Valid @RequestBody OrderServiceInputDTO orderServiceInputDTO){
        return orderServiceService.insert(orderServiceInputDTO);
    }

    @GetMapping
    public List<OrderServiceDTO> findAll(){
        return orderServiceService.findAll();
    }

    @PostMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderServiceDTO findByIdComments(@PathVariable Long id, @RequestBody CommentInputDTO commentInputDTO){
        return orderServiceService.insertComment(id, commentInputDTO);
    }
}
