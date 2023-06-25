package br.paulotrc.svcautomovel.entities;

import br.paulotrc.svcautomovel.entities.enumerados.TipoAutomovel;
import br.paulotrc.svcautomovel.entities.enumerados.TipoRestricaoAutomovel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@Setter
@AllArgsConstructor
@Document //Anotação mongo para mapeamento do document.
public class Automovel {

    @Id
    private UUID id = UUID.randomUUID();
    private String cpf; //Documento de identificação do dono do automovel
    private String placa;
    private String renavam;
    private String categoria;
    private String combustivel;
    private String marca;
    private String modelo;
    private String anoFabricacao;
    private String anoModelo;
    private String cor;
    private String potencia;
    private Boolean financiado;
    private LocalDate dataCompra;
    private LocalDate dataFimContrato;
    private LocalDate dataQuitacao;
    private Integer parcelasTotais;
    private Integer parcelasPagas;
    private TipoRestricaoAutomovel restricaoAutomovel;
    private TipoAutomovel tipoAutomovel;
}

