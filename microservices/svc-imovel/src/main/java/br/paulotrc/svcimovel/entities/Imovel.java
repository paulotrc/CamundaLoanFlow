package br.paulotrc.svcimovel.entities;

import br.paulotrc.svcimovel.entities.enumerados.TipoImovel;
import br.paulotrc.svcimovel.entities.enumerados.TipoRestricaoImovel;
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
public class Imovel {

    @Id
    private UUID id = UUID.randomUUID();
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

