package br.paulotrc.svcserasa.repositories;

import br.paulotrc.svcserasa.entites.Serasa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MongoSerasaRepository extends MongoRepository<Serasa, UUID> {

    @Query("{cpf: { $regex: ?0 } })")
    List<Serasa> consultarPorCpf(String cpf);
}
