package br.paulotrc.contratacaoflow.datasources;

import br.paulotrc.contratacaoflow.datasources.feign.AutomovelClient;
import br.paulotrc.contratacaoflow.entities.automovel.ResponseAutomovelData;
import br.paulotrc.contratacaoflow.exceptions.http.NotFoundException;
import br.paulotrc.contratacaoflow.fixtures.ResponseAutomovelDataFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutomovelDataSourceTest {

    @InjectMocks
    AutomovelDataSource automovelDataSource;

    @Mock
    AutomovelClient automovelClient;
    final String cpf = "47742788233";

    @Test
    @DisplayName("Should search automobile using customer document Cpf")
    void consultarAutomovelClientePeloCpf() {
        ResponseAutomovelData responseAutomovelDataActual = ResponseAutomovelDataFixture.gerarAutomovel();
        when(automovelDataSource.consultarAutomovelClientePeloCpf(Mockito.isA(String.class))).thenReturn(List.of(responseAutomovelDataActual));
        ResponseAutomovelData contratacaoExpected = automovelDataSource.consultarAutomovelClientePeloCpf(cpf).get(0);
        Assertions.assertNotNull(contratacaoExpected);
        Assertions.assertEquals(contratacaoExpected, responseAutomovelDataActual);
    }

    @Test
    @DisplayName("Should throw Runtime type Exception")
    void lancaExceptionAoConsultarAutomovelClientePeloCpf() {
        when(automovelDataSource.consultarAutomovelClientePeloCpf(Mockito.isA(String.class))).thenThrow(new NotFoundException());
        Assertions.assertThrows(RuntimeException.class, ()-> automovelDataSource.consultarAutomovelClientePeloCpf(cpf));
    }
}