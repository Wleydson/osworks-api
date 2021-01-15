package com.wleydsonlemos.osworksapi.domain.service;

import com.wleydsonlemos.osworksapi.api.dto.ClientDTO;
import com.wleydsonlemos.osworksapi.api.dto.ClientInputDTO;
import com.wleydsonlemos.osworksapi.domain.exception.BusinessException;
import com.wleydsonlemos.osworksapi.domain.model.Client;
import com.wleydsonlemos.osworksapi.domain.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ClientDTO> findAll(){
        return repository.findAll().stream().map(client -> toDTO(client)).collect(Collectors.toList());
    }


    public ClientDTO findById(Long id){
        Optional<Client> client =  repository.findById(id);
        if(client.isPresent()){
            return toDTO(client.get());
        }
        return null;
    }

    public ClientDTO save(ClientInputDTO clientInputDTO){
        Client client = toEntity(clientInputDTO);
        Client clientExist = repository.findByEmail(client.getEmail());
        if(clientExist != null && !clientExist.equals(client)){
            throw new BusinessException("Email já cadastrado");
        }
        return toDTO(repository.save(client));
    }

    public ClientDTO update(Long id, ClientInputDTO clientInputDTO){
        Client client = toEntity(clientInputDTO);
        if(repository.existsById(id)){
            client.setId(id);
            client = repository.save(client);
            return toDTO(client);
        }
        return null;
    }

    public boolean delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private ClientDTO toDTO(Client client){
        return modelMapper.map(client, ClientDTO.class);
    }

    private Client toEntity(ClientInputDTO dto){
        return modelMapper.map(dto, Client.class);
    }
}
