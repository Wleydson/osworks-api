package com.wleydsonlemos.osworksapi.domain.service;

import com.wleydsonlemos.osworksapi.api.dto.CommentDTO;
import com.wleydsonlemos.osworksapi.api.dto.CommentInputDTO;
import com.wleydsonlemos.osworksapi.api.dto.OrderServiceDTO;
import com.wleydsonlemos.osworksapi.api.dto.OrderServiceInputDTO;
import com.wleydsonlemos.osworksapi.domain.exception.BusinessException;
import com.wleydsonlemos.osworksapi.domain.model.Client;
import com.wleydsonlemos.osworksapi.domain.model.Comment;
import com.wleydsonlemos.osworksapi.domain.model.OrderService;
import com.wleydsonlemos.osworksapi.domain.model.enumeration.StatusOrdemService;
import com.wleydsonlemos.osworksapi.domain.repository.ClientRepository;
import com.wleydsonlemos.osworksapi.domain.repository.CommentRepository;
import com.wleydsonlemos.osworksapi.domain.repository.OrderServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceService {

    @Autowired
    private OrderServiceRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderServiceDTO insert(OrderServiceInputDTO orderServiceInputDTO){
        OrderService orderService = toEntity(orderServiceInputDTO);

        Client client = clientRepository.findById(orderService.getClient().getId()).orElseThrow(() -> new BusinessException("Cliente não encontrado"));
        orderService.setStatus(StatusOrdemService.OPEN);
        orderService.setDateInitial(OffsetDateTime.now());

        orderService = repository.save(orderService);
        orderService.setClient(client);
        return toDTO(orderService);
    }

    public List<OrderServiceDTO> findAll() {
        List<OrderService> orderServices = repository.findAll();
        List<OrderServiceDTO> orderServiceDTOS = orderServices.stream().map(orderService -> toDTO(orderService)).collect(Collectors.toList());
        return orderServiceDTOS;
    }


    public OrderServiceDTO findById(Long id) {
        Optional<OrderService> orderService = repository.findById(id);
        if(orderService.isPresent()){
           return toDTO(orderService.get());
        }
        return null;
    }

    public OrderServiceDTO insertComment(Long id, CommentInputDTO dto){
        OrderService orderService = repository.findById(id).orElseThrow(() -> new BusinessException("Serviço não encontrado"));
        Comment comment = modelMapper.map(dto, Comment.class);
        comment.setOrderService(orderService);
        comment.setDate(OffsetDateTime.now());
        comment = commentRepository.save(comment);
        orderService.getComments().add(comment);
        return toDTO(orderService);
    }

    private OrderServiceDTO toDTO(OrderService orderService){
        return modelMapper.map(orderService, OrderServiceDTO.class);
    }

    private OrderService toEntity(OrderServiceInputDTO dto){
        return modelMapper.map(dto, OrderService.class);
    }
}
