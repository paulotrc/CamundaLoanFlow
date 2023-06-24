package br.paulotrc.svcimovel.datasources;

import br.paulotrc.svcimovel.datasources.feign.ApiCepClient;
import br.paulotrc.svcimovel.entites.Imovel;
import br.paulotrc.svcimovel.entites.feign.ResponseApiCepData;
import br.paulotrc.svcimovel.repositories.ApiCepRepository;
import br.paulotrc.svcimovel.repositories.ImovelRepository;
import br.paulotrc.svcimovel.repositories.MongoImovelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApiCepDataSource implements ApiCepRepository {

    private static final String MESSAGE_JSON_ERROR = "Falha ao recuperar os dados de ApiCep!";
    private final Logger log = LoggerFactory.getLogger(ApiCepDataSource.class);
    private final ApiCepClient apiCepClient;

    @Override
    public ResponseApiCepData consultarPorCep(String cep) {
        final ResponseApiCepData response;
        try {
            response = apiCepClient.consultarPorCep(cep);
        } catch (RuntimeException ex) {
            log.error(MESSAGE_JSON_ERROR, ex.getCause());
            throw ex;
        }
        return response;
    }
}
