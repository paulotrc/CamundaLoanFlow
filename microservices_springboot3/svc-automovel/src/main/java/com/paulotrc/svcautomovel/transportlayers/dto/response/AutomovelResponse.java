package com.paulotrc.svcautomovel.transportlayers.dto.response;

import com.paulotrc.svcautomovel.entities.enumerados.TipoAutomovel;
import com.paulotrc.svcautomovel.entities.enumerados.TipoRestricaoAutomovel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AutomovelResponse {

    private UUID id;
    private String cpf; //Documento de identificação do dono do automóvel
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

