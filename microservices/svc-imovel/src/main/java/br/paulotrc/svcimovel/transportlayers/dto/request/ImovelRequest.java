package br.paulotrc.svcimovel.transportlayers.dto.request;

import br.paulotrc.svcimovel.entites.enumerados.TipoImovel;
import br.paulotrc.svcimovel.entites.enumerados.TipoRestricaoImovel;
import br.paulotrc.svcimovel.entites.validators.TipoImovelValidator;
import br.paulotrc.svcimovel.entites.validators.TipoRestricaoImovelValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ImovelRequest {

    private UUID id = UUID.randomUUID();

    @NotBlank(message = "CPF é obrigatório")
    private String cpf; //Documento de identificação do dono do imóvel

    @NotBlank(message = "Cep é obrigatório")
    @Pattern(regexp = "^\\d{1,5}-\\d{1,3}$", message = "Cep inválido, utilize o seguinte formato: 99999-99.")
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;
    @NotBlank(message = "Número é obrigatório")
    private String numero;
    @NotBlank(message = "Complemento é obrigatório")
    private String complemento;
    private String referencia;
    @PastOrPresent(message = "DataCompra é obrigatório e não pode ser compra futura.")
    private LocalDate dataCompra;
    private LocalDate dataFimContrato;
    private LocalDate dataQuitacao;
    @Positive(message = "ParcelasTotais é obrigatório e deve ser maior que zero.")
    private Integer parcelasTotais;
    @PositiveOrZero(message = "ParcelasPagas é obrigatório, caso ainda não tenha nenhuma parcela paga, indicar como 0 (zero).")
    private Integer parcelasPagas;
    @TipoRestricaoImovelValidator(regexp = "DIVIDA|SITUACAO_CADASTRAL|CPF_CANCELADO|CPF_PENDENTE|CPF_NULO")
    private TipoRestricaoImovel restricaoImovel;
    @TipoImovelValidator(regexp = "CASA|APARTAMENTO|FLAT|KITNET|GALPAO")
    private TipoImovel tipoImovel;
}

