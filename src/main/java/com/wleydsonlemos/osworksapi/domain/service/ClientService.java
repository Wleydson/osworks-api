package com.wleydsonlemos.osworksapi.domain.service;

import com.wleydsonlemos.osworksapi.domain.exception.BusinessException;
import com.wleydsonlemos.osworksapi.domain.model.Client;
import com.wleydsonlemos.osworksapi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }


    public Client findById(Long id){
        Optional<Client> client =  repository.findById(id);
        if(client.isPresent()){
            return client.get();
        }
        return null;
    }

    public Client save(Client client){
        Client clientExist = repository.findByEmail(client.getEmail());
        if(clientExist != null && !clientExist.equals(client)){
            throw new BusinessException("Email já cadastrado");
        }
        return repository.save(client);
    }

    public Client update(Long id, Client client){
        if(repository.existsById(id)){
            client.setId(id);
            client = repository.save(client);
            return client;
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
}
