package com.paulotrc.svcclientes.iteractors;

import com.paulotrc.svcclientes.entites.Cliente;
import com.paulotrc.svcclientes.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteUseCase {

    private ClienteRepository clienteRepository;

    public ClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente gravarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> consultaTodos() {
        return clienteRepository.findAll();
    }

    public List<Cliente> consultarPorCpf(String cpf) {
        return clienteRepository.consultarPorCpf(cpf);
    }
}
