package br.paulotrc.svcserasa.transportlayers.impl;

import br.paulotrc.svcserasa.entites.Serasa;
import br.paulotrc.svcserasa.exceptions.ExceptionUtil;
import br.paulotrc.svcserasa.exceptions.ResourceException;
import br.paulotrc.svcserasa.iteractors.SerasaUseCase;
import br.paulotrc.svcserasa.transportlayers.SerasaResourceI;
import br.paulotrc.svcserasa.transportlayers.dto.request.SerasaRequest;
import br.paulotrc.svcserasa.transportlayers.dto.response.SerasaResponse;
import br.paulotrc.svcserasa.transportlayers.mappers.SerasaMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class SerasaResource implements SerasaResourceI {

    private SerasaUseCase serasaUseCase;

    public SerasaResource(SerasaUseCase serasaUseCase) {
        this.serasaUseCase = serasaUseCase;
    }

    @Override
    public ResponseEntity<List<SerasaResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    ) {
        List<Serasa> serasas = null;
        try {
            serasas = serasaUseCase.consultarPorCpf(cpf);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(SerasaMapper.INSTANCE.mapListResponse(serasas));
    }

    @Override
    public ResponseEntity<List<SerasaResponse>> getAll() {
        List<Serasa> serasas = null;
        try {
            serasas = serasaUseCase.consultaTodos();
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(SerasaMapper.INSTANCE.mapListResponse(serasas));
    }

    @Override
    public ResponseEntity<SerasaResponse> post(@Valid @RequestBody SerasaRequest serasaRequest) {
        Serasa serasa = null;
        try {
            serasa = serasaUseCase.gravarSerasa(SerasaMapper.INSTANCE.map(serasaRequest));
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(SerasaMapper.INSTANCE.mapResponse(serasa));
    }
}
