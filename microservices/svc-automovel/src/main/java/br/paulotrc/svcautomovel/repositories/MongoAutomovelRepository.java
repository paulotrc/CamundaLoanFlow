package br.paulotrc.svcautomovel.repositories;

import br.paulotrc.svcautomovel.entities.Automovel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MongoAutomovelRepository extends MongoRepository<Automovel, UUID> {

    @Query("{cpf: { $regex: ?0 } })")
    List<Automovel> consultarPorCpf(String cpf);

    @Query("{placa: { $regex: ?0 } })")
    List<Automovel> consultarPorPlaca(String cep);
}
