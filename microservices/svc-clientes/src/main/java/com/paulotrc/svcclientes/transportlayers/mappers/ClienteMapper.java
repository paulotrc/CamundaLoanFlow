package com.paulotrc.svcclientes.transportlayers.mappers;

import com.paulotrc.svcclientes.entites.Cliente;
import com.paulotrc.svcclientes.transportlayers.dto.request.ClienteRequest;
import com.paulotrc.svcclientes.transportlayers.dto.response.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente map(ClienteRequest clienteRequest);

    ClienteResponse mapResponse(Cliente cliente);

    default List<ClienteResponse> mapListResponse(List<Cliente> clientes){
        final List<ClienteResponse> clienteResponseList = new ArrayList<>();
        for (Cliente cliente:clientes) {
            ClienteResponse cliResp = ClienteMapper.INSTANCE.mapResponse(cliente);
            clienteResponseList.add(cliResp);
        }
        return clienteResponseList;
    }
}

