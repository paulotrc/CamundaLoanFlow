package com.paulotrc.svcclientes.repositories;

import com.paulotrc.svcclientes.entites.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MongoClienteRepository extends MongoRepository<Cliente, UUID> {

    @Query("{cpf: { $regex: ?0 } })")
    List<Cliente> consultarPorCpf(String cpf);
}
