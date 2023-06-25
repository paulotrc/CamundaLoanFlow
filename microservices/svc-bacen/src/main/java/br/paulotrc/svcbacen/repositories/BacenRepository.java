package br.paulotrc.svcbacen.repositories;

import br.paulotrc.svcbacen.entities.Bacen;

import java.util.List;

public interface BacenRepository {

        Bacen save(Bacen bacen);
        List<Bacen> findAll();
        List<Bacen> consultarPorCpf(String cpf);

    }

