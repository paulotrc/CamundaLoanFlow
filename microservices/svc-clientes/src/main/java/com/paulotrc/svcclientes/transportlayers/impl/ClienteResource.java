package com.paulotrc.svcclientes.transportlayers.impl;

import com.paulotrc.svcclientes.entites.Cliente;
import com.paulotrc.svcclientes.exceptions.ExceptionUtil;
import com.paulotrc.svcclientes.exceptions.ResourceException;
import com.paulotrc.svcclientes.iteractors.ClienteUseCase;
import com.paulotrc.svcclientes.transportlayers.ClienteResourceI;
import com.paulotrc.svcclientes.transportlayers.dto.request.ClienteRequest;
import com.paulotrc.svcclientes.transportlayers.dto.response.ClienteResponse;
import com.paulotrc.svcclientes.transportlayers.mappers.ClienteMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class ClienteResource implements ClienteResourceI {

    private ClienteUseCase clienteUseCase;

    public ClienteResource(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @Override
    public ResponseEntity<List<ClienteResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    ) {
        List<Cliente> clientes = null;
        try {
            clientes = clienteUseCase.consultarPorCpf(cpf);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(ClienteMapper.INSTANCE.mapListResponse(clientes));
    }

    @Override
    public ResponseEntity<List<ClienteResponse>> getAll() {
        List<Cliente> clientes = null;
        try {
            clientes = clienteUseCase.consultaTodos();
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(ClienteMapper.INSTANCE.mapListResponse(clientes));
    }

    @Override
    public ResponseEntity<ClienteResponse> post(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = null;
        try {
            cliente = clienteUseCase.gravarCliente(ClienteMapper.INSTANCE.map(clienteRequest));
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(ClienteMapper.INSTANCE.mapResponse(cliente));
    }
}
