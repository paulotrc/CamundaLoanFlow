package br.paulotrc.svcserasa.entites;

import br.paulotrc.svcserasa.entites.enumerados.TipoRestricaoSerasa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@Document //Anotação mongo para mapeamento do document.
public class Serasa {

    @Id
    private UUID id = UUID.randomUUID();
    private String cpf;
    private Boolean temRestricao;
    private TipoRestricaoSerasa tipoRestricaoSerasa;
    private BigDecimal valorRestricao;
}

