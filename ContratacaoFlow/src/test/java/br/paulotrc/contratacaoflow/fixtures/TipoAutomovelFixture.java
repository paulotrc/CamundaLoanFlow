package br.paulotrc.contratacaoflow.fixtures;

import br.paulotrc.contratacaoflow.entities.enumerados.automovel.TipoAutomovel;

public class TipoAutomovelFixture {
    public static TipoAutomovel gerarTipoAutomovelCarro() {
        return TipoAutomovel.CARRO;
    }

    public static TipoAutomovel gerarTipoAutomovelCaminhao() {
        return TipoAutomovel.CAMINHAO;
    }

    public static TipoAutomovel gerarTipoAutomovelCaminhonete() {
        return TipoAutomovel.CAMINHONETE;
    }

    public static TipoAutomovel gerarTipoAutomovelSuv() {
        return TipoAutomovel.SUV;
    }
}
