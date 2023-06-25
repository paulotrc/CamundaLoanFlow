package br.paulotrc.contratacaoflow.fixtures;

import br.paulotrc.contratacaoflow.entities.automovel.ResponseAutomovelData;

import java.time.LocalDate;
import java.util.UUID;

public class ResponseAutomovelDataFixture {

    public static ResponseAutomovelData gerarAutomovel() {
        return new ResponseAutomovelData(
        UUID.randomUUID(),
        "cpf",
        "placa",
        "renavam",
        "categoria",
        "combustivel",
        "marca",
        "modelo",
        "anoFabricacao",
        "anoModelo",
        "cor",
        "potencia",
        true,
        LocalDate.now(),
        LocalDate.now(),
        LocalDate.now(),
        10,
        2,
        TipoRestricaoAutomovelFixture.gerarRestricaoAutomovel(),
        TipoAutomovelFixture.gerarTipoAutomovelCarro(),
        StatusFixture.gerarStatus()
        );
    }
}
