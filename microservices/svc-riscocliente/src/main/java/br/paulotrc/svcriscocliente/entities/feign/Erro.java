package br.paulotrc.svcriscocliente.entities.feign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Erro {
    @JsonProperty("mensagem")
    private String mensagem;
    @JsonProperty("codigo")
    private String codigo;
}
