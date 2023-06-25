package br.paulotrc.svcriscocliente.transportlayers.dto.response;

import br.paulotrc.svcriscocliente.entities.enumerados.TipoRiscoCliente;
import br.paulotrc.svcriscocliente.entities.enumerados.TipoRestricaoRiscoCliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RiscoClienteResponse {

    private UUID id;
    private String cpf; //Documento de identificação do dono do imóvel
    private LocalDate dataInclusao;
    private Integer validadeEmMeses;
    private TipoRiscoCliente tipoRiscoCliente;
    private List<TipoRestricaoRiscoCliente> restricoesRiscoCliente;
    private Boolean riscoAtivo;
    private Boolean podeTomarEmprestimo;
}

