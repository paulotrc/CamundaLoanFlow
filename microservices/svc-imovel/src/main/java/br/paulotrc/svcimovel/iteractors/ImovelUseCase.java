package br.paulotrc.svcimovel.iteractors;

import br.paulotrc.svcimovel.entites.Imovel;
import br.paulotrc.svcimovel.repositories.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelUseCase {

    private ImovelRepository imovelRepository;

    public ImovelUseCase(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public Imovel gravarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public List<Imovel> consultaTodos() {
        return imovelRepository.findAll();
    }

    public List<Imovel> consultarPorCpf(String cpf) {
        return imovelRepository.consultarPorCpf(cpf);
    }

    public List<Imovel> consultarPorCep(String cep) {
        return imovelRepository.consultarPorCep(cep);
    }

    public Boolean cepExiste(String cep){

        return false;
    }

}
