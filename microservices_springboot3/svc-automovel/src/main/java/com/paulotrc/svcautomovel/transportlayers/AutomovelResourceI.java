package com.paulotrc.svcautomovel.transportlayers;

import com.paulotrc.svcautomovel.transportlayers.dto.request.AutomovelRequest;
import com.paulotrc.svcautomovel.transportlayers.dto.response.AutomovelResponse;
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
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Automovel", description = "Operações com Automovel")
@RequestMapping(value = "/api/v1")
public interface AutomovelResourceI {

    @Operation(summary = "Obter as infromações do Automovel de um cliente pelo seu cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Automóvel encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutomovelRequest.class))}),
            @ApiResponse(responseCode = "400", description = "Automóvel não encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "404", description = "Erro",
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
    @GetMapping (value = "/automovel/cliente/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Valid
    ResponseEntity<List<AutomovelResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @Valid @Size(min = 11, max = 11) @PathVariable("cpf") String cpf
    );

    @Operation(summary = "Obter as informações do Automovel pela Placa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Automóvel encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutomovelRequest.class))}),
            @ApiResponse(responseCode = "400", description = "Automóvel não encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "404", description = "Erro",
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
    @GetMapping (value = "/automovel/placa/{placa}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Valid
    ResponseEntity<List<AutomovelResponse>> getPorPlaca(
            @Parameter(name = "placa", description = "Placa do automóvel", required = true)
            @Valid @Size(min = 6, max = 7)
            @Pattern(regexp = "^([a-zA-Z]{2}|[a-zA-Z]{3})[0-9][A-Za-z0-9][0-9]{2}$", message = "Placa inválida, utilize os seguintes formatos: (AA9999|AAA9999|AAA9A99).")
            @PathVariable("placa") String placa
    );

    @Operation(summary = "Obter todas as informações do automóvel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações do Automóvel encontradas",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutomovelRequest.class))}),
            @ApiResponse(responseCode = "400", description = "Informações não encontradas",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "404", description = "Erro",
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
    @GetMapping (value = "/automovel/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Valid
    ResponseEntity<List<AutomovelResponse>> getAll();

    @Operation(summary = "Salvar os dados de informação de um automóvel de um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Automóvel cadastrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutomovelResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @CircuitBreaker(name = "processServiceMongo", fallbackMethod = "fallback")
    @Retry(name = "default")
    @PostMapping (value = "/automovel", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<AutomovelResponse> post(@Valid @RequestBody AutomovelRequest automovelRequest);

}
