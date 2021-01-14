package com.wleydsonlemos.osworksapi.domain.service;

import com.wleydsonlemos.osworksapi.domain.exception.BusinessException;
import com.wleydsonlemos.osworksapi.domain.model.Client;
import com.wleydsonlemos.osworksapi.domain.model.OrderService;
import com.wleydsonlemos.osworksapi.domain.model.enumeration.StatusOrdemService;
import com.wleydsonlemos.osworksapi.domain.repository.ClientRepository;
import com.wleydsonlemos.osworksapi.domain.repository.OrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceService {

    @Autowired
    private OrderServiceRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    public OrderService insert(OrderService orderService){
        Client client = clientRepository.findById(orderService.getClient().getId()).orElseThrow(() -> new BusinessException("Cliente não encontrado"));
        orderService.setStatus(StatusOrdemService.OPEN);
        orderService.setDateInitial(LocalDateTime.now());

        orderService = repository.save(orderService);
        orderService.setClient(client);
        return orderService;
    }
}
