package br.paulotrc.svcimovel.repositories;

import br.paulotrc.svcimovel.entites.Imovel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MongoImovelRepository extends MongoRepository<Imovel, UUID> {

    @Query("{cpf: { $regex: ?0 } })")
    List<Imovel> consultarPorCpf(String cpf);

    @Query("{cep: { $regex: ?0 } })")
    List<Imovel> consultarPorCep(String cep);
}
