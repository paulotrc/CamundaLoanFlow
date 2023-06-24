package br.paulotrc.svcimovel.repositories;

import br.paulotrc.svcimovel.entites.Imovel;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ImovelRepository {

        Imovel save(Imovel imovel);
        List<Imovel> findAll();
        List<Imovel> consultarPorCpf(String cpf);
        List<Imovel> consultarPorCep(String cep);

    }

