package br.paulotrc.svcserasa.repositories;

import br.paulotrc.svcserasa.entities.Serasa;

import java.util.List;

public interface SerasaRepository {

        Serasa save(Serasa serasa);
        List<Serasa> findAll();
        List<Serasa> consultarPorCpf(String cpf);

    }

