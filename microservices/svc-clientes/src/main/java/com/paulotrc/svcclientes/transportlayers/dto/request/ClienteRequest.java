package com.paulotrc.svcclientes.transportlayers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ClienteRequest {

    private UUID id = UUID.randomUUID();
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    @NotBlank(message = "DDD é obrigatório")
    private String ddd;
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
    @NotNull(message = "Indicativo de se tem Imóvel é obrigatório")
    private Boolean temImovel;
    @NotNull(message = "Indicativo de se tem Automóvel é obrigatório")
    private Boolean temAutomovel;
    @Positive(message = "Valor da renda deve ser maior que zero.")
    private BigDecimal renda;
}

