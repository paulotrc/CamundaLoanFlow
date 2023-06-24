package br.paulotrc.svcserasa.transportlayers.dto.response;

import br.paulotrc.svcserasa.entites.enumerados.TipoRestricaoSerasa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SerasaResponse {

    private UUID id;
    private String cpf;
    private Boolean temRestricao;
    private TipoRestricaoSerasa tipoRestricaoSerasa;
    private BigDecimal valorRestricao;
}

