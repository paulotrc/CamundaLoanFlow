package br.paulotrc.svcautomovel.entities.enumerados;

public enum TipoRestricaoAutomovel {
    IMPOSTO_ATRASADO("Imposto Atrasado"),
    SITUACAO_CADASTRAL("Situação Cadastral"),
    FURTADO("Furtado"),
    PERDA_TOTAL("Perda Total"),
    MULTA("Com Multas");

    private String descricao;

    TipoRestricaoAutomovel(String descricao) {
        this.descricao = descricao;
    }
}