package br.paulotrc.contratacaoflow.fixtures;

import br.paulotrc.contratacaoflow.entities.enumerados.bacen.TipoRestricaoBacen;

public class TipoRestricaoBacenFixture {
    public static TipoRestricaoBacen gerarTipoRestricaoBacen() {
        return TipoRestricaoBacen.EXCLUSAO_CLIENTE;
    }
}
