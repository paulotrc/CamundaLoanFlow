package br.paulotrc.svcserasa.transportlayers;

import br.paulotrc.svcserasa.transportlayers.dto.request.SerasaRequest;
import br.paulotrc.svcserasa.transportlayers.dto.response.SerasaResponse;
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

@Tag(name = "Serasa", description = "Operações com Serasa")
@RequestMapping(value = "/api/v1")
public interface SerasaResourceI {

    @Operation(summary = "Obter as restrições do Serasa de um cliente pelo seu cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restrição encontrada",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SerasaRequest.class))}),
            @ApiResponse(responseCode = "400", description = "Restrição não encontrada",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @GetMapping (value = "/serasa/cpf/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Valid
    ResponseEntity<List<SerasaResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    );

    @Operation(summary = "Obter todas as restriçoes do cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restrições encontradas",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SerasaRequest.class))}),
            @ApiResponse(responseCode = "400", description = "Restrições não encontradas",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @GetMapping (value = "/serasa/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Valid
    ResponseEntity<List<SerasaResponse>> getAll();

    @Operation(summary = "Salvar os dados de uma restrição de um cliente para o Serasa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restrição cadastrada",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SerasaResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @PostMapping (value = "/serasa", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SerasaResponse> post(@Valid @RequestBody SerasaRequest serasaRequest);

}
