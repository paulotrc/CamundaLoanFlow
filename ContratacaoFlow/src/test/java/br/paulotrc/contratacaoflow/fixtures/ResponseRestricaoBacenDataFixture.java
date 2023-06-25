package br.paulotrc.contratacaoflow.fixtures;

import br.paulotrc.contratacaoflow.entities.bacen.ResponseRestricaoBacenData;

import java.math.BigDecimal;
import java.util.UUID;

public class ResponseRestricaoBacenDataFixture {

    public static ResponseRestricaoBacenData gerarRestricaoBacen() {
        return new ResponseRestricaoBacenData(
                UUID.randomUUID(),
                "cpf",
                true,
                TipoRestricaoBacenFixture.gerarTipoRestricaoBacen(),
                BigDecimal.TEN,
                StatusFixture.gerarStatus()
        );
    }
}
