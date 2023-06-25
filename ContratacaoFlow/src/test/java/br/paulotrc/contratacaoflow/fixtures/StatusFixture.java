package br.paulotrc.contratacaoflow.fixtures;

import br.paulotrc.contratacaoflow.entities.Erro;
import br.paulotrc.contratacaoflow.entities.Erros;
import br.paulotrc.contratacaoflow.entities.Status;

import java.util.List;

public class StatusFixture {
    public static Status gerarStatus() {
        Erro erro = new Erro("Sample error message", "E001");
        Erros erros = new Erros(List.of(erro), "Sample error message");
        return new Status("S001", erros);
    }
}
