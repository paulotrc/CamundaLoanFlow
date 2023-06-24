package br.paulotrc.svcimovel.transportlayers.dto.response;

import br.paulotrc.svcimovel.entites.enumerados.TipoImovel;
import br.paulotrc.svcimovel.entites.enumerados.TipoRestricaoImovel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ImovelResponse {

    private UUID id;
    private String cpf; //Documento de identificação do dono do imóvel
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;
    private String numero;
    private String complemento;
    private String referencia;
    private LocalDate dataCompra;
    private LocalDate dataFimContrato;
    private LocalDate dataQuitacao;
    private Integer parcelasTotais;
    private Integer parcelasPagas;
    private TipoRestricaoImovel restricaoImovel;
    private TipoImovel tipoImovel;
}

