package com.paulotrc.svcclientes.repositories;

import com.paulotrc.svcclientes.entites.Cliente;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClienteRepository {

        Cliente save(Cliente cliente);
        List<Cliente> findAll();
        List<Cliente> consultarPorCpf(String cpf);

    }

