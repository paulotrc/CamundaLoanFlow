package com.paulotrc.svcclientes.datasources;

import com.paulotrc.svcclientes.entities.Cliente;
import com.paulotrc.svcclientes.repositories.ClienteRepository;
import com.paulotrc.svcclientes.repositories.MongoClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteDataSource implements ClienteRepository {

    private final Logger log = LoggerFactory.getLogger(ClienteDataSource.class);
    private MongoClienteRepository mongoClienteRepository;

    public ClienteDataSource(MongoClienteRepository mongoClienteRepository) {
        this.mongoClienteRepository = mongoClienteRepository;
    }

    public Cliente save(Cliente cliente){
        return this.mongoClienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return this.mongoClienteRepository.findAll();
    }

    @Override
    public List<Cliente> consultarPorCpf(String cpf) {
        return mongoClienteRepository.consultarPorCpf(cpf);
    }
}
