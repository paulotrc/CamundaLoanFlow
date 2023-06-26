package br.paulotrc.contratacaoflow.fixtures;

import br.paulotrc.contratacaoflow.entities.Status;
import br.paulotrc.contratacaoflow.entities.automovel.ResponseAutomovelData;
import br.paulotrc.contratacaoflow.entities.cliente.ResponseClienteData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ResponseClienteDataFixture {

    public static ResponseClienteData gerarCliente() {
        return new ResponseClienteData(
        UUID.randomUUID(),
        "nome",
        "cpf",
        "ddd",
        "telefone",
        true,
        true,
        BigDecimal.TEN,
        StatusFixture.gerarStatus()
        );
    }
}
