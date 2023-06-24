package br.paulotrc.contratacaoflow.datasources.feign.configuration.imovel;

import br.paulotrc.contratacaoflow.entities.imovel.ResponseImovelData;
import br.paulotrc.contratacaoflow.exceptions.feign.GatewayResourceIntegrationRuntimeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

public class ImovelErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String s, Response response) {
        try {
            InputStream body = response.body().asInputStream();

            ResponseImovelData responseImovelData = objectMapper.readValue(body, ResponseImovelData.class);

            return new GatewayResourceIntegrationRuntimeException(
                    responseImovelData.getStatus().getErros().getMsgErro(),
                    responseImovelData.getStatus().getCodigo(),
                    HttpStatus.valueOf(response.status()),
                    "INTERNAL");

        } catch (IOException e) {
            return new GatewayResourceIntegrationRuntimeException(response.reason(),
                    response.body().toString(),
                    HttpStatus.valueOf(response.status()),
                    "INTERNAL");
        }
    }

}
