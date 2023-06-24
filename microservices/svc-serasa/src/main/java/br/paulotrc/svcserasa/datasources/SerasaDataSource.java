package br.paulotrc.svcserasa.datasources;

import br.paulotrc.svcserasa.entites.Serasa;
import br.paulotrc.svcserasa.repositories.SerasaRepository;
import br.paulotrc.svcserasa.repositories.MongoSerasaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerasaDataSource implements SerasaRepository {

    private final Logger log = LoggerFactory.getLogger(SerasaDataSource.class);
    private MongoSerasaRepository mongoSerasaRepository;

    public SerasaDataSource(MongoSerasaRepository mongoSerasaRepository) {
        this.mongoSerasaRepository = mongoSerasaRepository;
    }

    public Serasa save(Serasa serasa){
        return this.mongoSerasaRepository.save(serasa);
    }

    public List<Serasa> findAll(){
        return this.mongoSerasaRepository.findAll();
    }

    @Override
    public List<Serasa> consultarPorCpf(String cpf) {
        return mongoSerasaRepository.consultarPorCpf(cpf);
    }
}
