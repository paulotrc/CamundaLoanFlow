package br.paulotrc.svcimovel.datasources;

import br.paulotrc.svcimovel.entites.Imovel;
import br.paulotrc.svcimovel.entites.feign.ResponseApiCepData;
import br.paulotrc.svcimovel.exceptions.bussiness.CepInexistenteException;
import br.paulotrc.svcimovel.exceptions.feign.GatewayResourceIntegrationRuntimeException;
import br.paulotrc.svcimovel.repositories.ApiCepRepository;
import br.paulotrc.svcimovel.repositories.ImovelRepository;
import br.paulotrc.svcimovel.repositories.MongoImovelRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImovelDataSource implements ImovelRepository {

    private final Logger log = LoggerFactory.getLogger(ImovelDataSource.class);
    private MongoImovelRepository mongoImovelRepository;
    private ApiCepRepository apiCepRepository;

    public Imovel save(Imovel imovel){
        ResponseApiCepData data = apiCepRepository.consultarPorCep(imovel.getCep());
        if(null != data){
            atualizaDadosComDadosRecuperadosDaApi(imovel, data);
            return this.mongoImovelRepository.save(imovel);
        }else{
            throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
        }
    }

    private void atualizaDadosComDadosRecuperadosDaApi(Imovel imovel, ResponseApiCepData data) {
        imovel.setEstado(data.getState());
        imovel.setCidade(data.getCity());
        imovel.setBairro(data.getDistrict());
        imovel.setEndereco(data.getAddress());
    }

    public List<Imovel> findAll(){
        return this.mongoImovelRepository.findAll();
    }

    @Override
    public List<Imovel> consultarPorCpf(String cpf) {
        return mongoImovelRepository.consultarPorCpf(cpf);
    }

    @Override
    public List<Imovel> consultarPorCep(String cep) {
        try {
            ResponseApiCepData data = apiCepRepository.consultarPorCep(cep);
            if(null != data){
                return mongoImovelRepository.consultarPorCep(cep);
            }else{
                throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
            }
        }catch (GatewayResourceIntegrationRuntimeException e){
            throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
        }
    }
}
