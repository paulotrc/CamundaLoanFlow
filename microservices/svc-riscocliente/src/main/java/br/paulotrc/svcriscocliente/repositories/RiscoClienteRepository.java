package br.paulotrc.svcriscocliente.repositories;

import br.paulotrc.svcriscocliente.entities.RiscoCliente;

import java.util.List;

public interface RiscoClienteRepository {
        RiscoCliente save(RiscoCliente riscoCliente);
        List<RiscoCliente> consultarPorCpf(String cpf);

    }

