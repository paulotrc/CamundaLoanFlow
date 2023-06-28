package com.paulotrc.svcautomovel.repositories;

import com.paulotrc.svcautomovel.entities.Automovel;

import java.util.List;

public interface AutomovelRepository {

        Automovel save(Automovel automovel);
        List<Automovel> findAll();
        List<Automovel> consultarPorCpf(String cpf);
        List<Automovel> consultarPorPlaca(String cep);

    }

