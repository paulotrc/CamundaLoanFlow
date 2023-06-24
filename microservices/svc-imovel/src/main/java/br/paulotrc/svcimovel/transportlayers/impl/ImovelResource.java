package br.paulotrc.svcimovel.transportlayers.impl;

import br.paulotrc.svcimovel.entites.Imovel;
import br.paulotrc.svcimovel.exceptions.ExceptionUtil;
import br.paulotrc.svcimovel.exceptions.ResourceException;
import br.paulotrc.svcimovel.iteractors.ImovelUseCase;
import br.paulotrc.svcimovel.transportlayers.ImovelResourceI;
import br.paulotrc.svcimovel.transportlayers.dto.request.ImovelRequest;
import br.paulotrc.svcimovel.transportlayers.dto.response.ImovelResponse;
import br.paulotrc.svcimovel.transportlayers.mappers.ImovelMapper;
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
public class ImovelResource implements ImovelResourceI {

    private ImovelUseCase imovelUseCase;

    public ImovelResource(ImovelUseCase imovelUseCase) {
        this.imovelUseCase = imovelUseCase;
    }

    @Override
    public ResponseEntity<List<ImovelResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    ) {
        List<Imovel> imovels = null;
        try {
            imovels = imovelUseCase.consultarPorCpf(cpf);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(ImovelMapper.INSTANCE.mapListResponse(imovels));
    }

    @Override
    public ResponseEntity<List<ImovelResponse>> getPorCep(
            @Parameter(name = "cep", description = "Cep do imóvel", required = true)
            @PathVariable("cep") String cep
    ) {
        List<Imovel> imovels = null;
        try {
            imovels = imovelUseCase.consultarPorCep(cep);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(ImovelMapper.INSTANCE.mapListResponse(imovels));
    }

    @Override
    public ResponseEntity<List<ImovelResponse>> getAll() {
        List<Imovel> imovels = null;
        try {
            imovels = imovelUseCase.consultaTodos();
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(ImovelMapper.INSTANCE.mapListResponse(imovels));
    }

    @Override
    public ResponseEntity<ImovelResponse> post(@Valid @RequestBody ImovelRequest imovelRequest) {
        Imovel imovel = null;
        try {
            imovel = imovelUseCase.gravarImovel(ImovelMapper.INSTANCE.map(imovelRequest));
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(ImovelMapper.INSTANCE.mapResponse(imovel));
    }
}
