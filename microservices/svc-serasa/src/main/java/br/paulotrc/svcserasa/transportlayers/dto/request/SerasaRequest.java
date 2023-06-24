package br.paulotrc.svcserasa.transportlayers.dto.request;

import br.paulotrc.svcserasa.entites.enumerados.TipoRestricaoSerasa;
import br.paulotrc.svcserasa.entites.validators.TipoRestricaoSerasaValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SerasaRequest {

    private UUID id = UUID.randomUUID();
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    @NotNull(message = "Indicativo de se tem restrição é obrigatório")
    private Boolean temRestricao;
    @TipoRestricaoSerasaValidator(regexp = "DIVIDA|SITUACAO_CADASTRAL|CPF_CANCELADO|CPF_PENDENTE|CPF_NULO")
    private TipoRestricaoSerasa tipoRestricaoSerasa;
    @PositiveOrZero(message = "Valor da restrição deve ser maior que zero ou zero.")
    private BigDecimal valorRestricao;
}

