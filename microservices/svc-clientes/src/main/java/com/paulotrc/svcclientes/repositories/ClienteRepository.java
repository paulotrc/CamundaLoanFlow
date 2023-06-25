package com.paulotrc.svcclientes.repositories;

import com.paulotrc.svcclientes.entities.Cliente;

import java.util.List;

public interface ClienteRepository {

        Cliente save(Cliente cliente);
        List<Cliente> findAll();
        List<Cliente> consultarPorCpf(String cpf);

    }

