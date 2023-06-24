package br.paulotrc.svcserasa.repositories;

import br.paulotrc.svcserasa.entites.Serasa;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SerasaRepository {

        Serasa save(Serasa serasa);
        List<Serasa> findAll();
        List<Serasa> consultarPorCpf(String cpf);

    }

