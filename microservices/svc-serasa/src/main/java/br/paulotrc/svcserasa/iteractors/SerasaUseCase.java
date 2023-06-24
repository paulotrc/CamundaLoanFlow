package br.paulotrc.svcserasa.iteractors;

import br.paulotrc.svcserasa.entites.Serasa;
import br.paulotrc.svcserasa.repositories.SerasaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerasaUseCase {

    private SerasaRepository serasaRepository;

    public SerasaUseCase(SerasaRepository serasaRepository) {
        this.serasaRepository = serasaRepository;
    }

    public Serasa gravarSerasa(Serasa serasa) {
        return serasaRepository.save(serasa);
    }

    public List<Serasa> consultaTodos() {
        return serasaRepository.findAll();
    }

    public List<Serasa> consultarPorCpf(String cpf) {
        return serasaRepository.consultarPorCpf(cpf);
    }
}
