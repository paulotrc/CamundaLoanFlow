package com.paulotrc.svcclientes.transportlayers;

import com.paulotrc.svcclientes.transportlayers.dto.request.ClienteRequest;
import com.paulotrc.svcclientes.transportlayers.dto.response.ClienteResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Cliente", description = "Operações com clientes")
@RequestMapping(value = "/api/v1")
public interface ClienteResourceI {

    @Operation(summary = "Obter um cliente pelo seu cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ClienteRequest.class))}),
            @ApiResponse(responseCode = "400", description = "Cliente não encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @CircuitBreaker(name = "processServiceMongo", fallbackMethod = "fallback")
    @Retry(name = "default")
    @GetMapping (value = "/cliente/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Valid
    ResponseEntity<List<ClienteResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    );

    @Operation(summary = "Obter todos os clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes encontrados",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ClienteRequest.class))}),
            @ApiResponse(responseCode = "400", description = "Clientes não encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @CircuitBreaker(name = "processServiceMongo", fallbackMethod = "fallback")
    @Retry(name = "default")
    @GetMapping (value = "/cliente/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Valid
    ResponseEntity<List<ClienteResponse>> getAll();

    @Operation(summary = "Salvar os dados de um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente cadastrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ClienteResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @CircuitBreaker(name = "processServiceMongo", fallbackMethod = "fallback")
    @Retry(name = "default")
    @PostMapping (value = "/cliente", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<ClienteResponse> post(@Valid @RequestBody ClienteRequest clienteRequest);

}
