package com.paulotrc.svcautomovel.transportlayers.impl;

import com.paulotrc.svcautomovel.entities.Automovel;
import com.paulotrc.svcautomovel.exceptions.ExceptionUtil;
import com.paulotrc.svcautomovel.exceptions.ResourceException;
import com.paulotrc.svcautomovel.interactors.AutomovelUseCase;
import com.paulotrc.svcautomovel.transportlayers.AutomovelResourceI;
import com.paulotrc.svcautomovel.transportlayers.dto.request.AutomovelRequest;
import com.paulotrc.svcautomovel.transportlayers.dto.response.AutomovelResponse;
import com.paulotrc.svcautomovel.transportlayers.mappers.AutomovelMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AutomovelResource implements AutomovelResourceI {

    private AutomovelUseCase automovelUseCase;

    public AutomovelResource(AutomovelUseCase automovelUseCase) {
        this.automovelUseCase = automovelUseCase;
    }

    @Override
    public ResponseEntity<List<AutomovelResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    ) {
        List<Automovel> automovels = null;
        try {
            automovels = automovelUseCase.consultarPorCpf(cpf);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(AutomovelMapper.INSTANCE.mapListResponse(automovels));
    }

    @Override
    public ResponseEntity<List<AutomovelResponse>> getPorPlaca(
            @Parameter(name = "placa", description = "Placa do automóvel", required = true)
            @Valid @Size(min = 6, max = 7)
            @Pattern(regexp = "^([a-zA-Z]{2}|[a-zA-Z]{3})[0-9][A-Za-z0-9][0-9]{2}$", message = "Placa inválida, utilize os seguintes formatos: (AA9999|AAA9999|AAA9A99).")
            @PathVariable("placa") String placa
    ) {
        List<Automovel> automovels = null;
        try {
            automovels = automovelUseCase.consultarPorPlaca(placa);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(AutomovelMapper.INSTANCE.mapListResponse(automovels));
    }

    @Override
    public ResponseEntity<List<AutomovelResponse>> getAll() {
        List<Automovel> automovels = null;
        try {
            automovels = automovelUseCase.consultaTodos();
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(AutomovelMapper.INSTANCE.mapListResponse(automovels));
    }

    @Override
    public ResponseEntity<AutomovelResponse> post(@Valid @RequestBody AutomovelRequest automovelRequest) {
        Automovel automovel = null;
        try {
            automovel = automovelUseCase.gravarAutomovel(AutomovelMapper.INSTANCE.map(automovelRequest));
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(AutomovelMapper.INSTANCE.mapResponse(automovel));
    }
}
