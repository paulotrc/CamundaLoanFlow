package br.paulotrc.contratacaoflow.datasources;

import br.paulotrc.contratacaoflow.datasources.feign.BacenClient;
import br.paulotrc.contratacaoflow.entities.bacen.ResponseRestricaoBacenData;
import br.paulotrc.contratacaoflow.exceptions.http.NotFoundException;
import br.paulotrc.contratacaoflow.fixtures.ResponseRestricaoBacenDataFixture;
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
class BacenDataSourceTest {

    @InjectMocks
    BacenDataSource bacenDataSource;

    @Mock
    BacenClient bacenClient;
    final String cpf = "47742788233";

    @Test
    @DisplayName("Should search bacen restriction using customer document Cpf")
    void consultarRestricaoBacenCpf() {
        ResponseRestricaoBacenData responseRestricaoBacenDataActual = ResponseRestricaoBacenDataFixture.gerarRestricaoBacen();
        when(bacenDataSource.consultarRestricaoBacen(Mockito.isA(String.class))).thenReturn(List.of(responseRestricaoBacenDataActual));
        ResponseRestricaoBacenData responseRestricaoBacenDataExpected = bacenDataSource.consultarRestricaoBacen(cpf).get(0);
        Assertions.assertNotNull(responseRestricaoBacenDataExpected);
        Assertions.assertEquals(responseRestricaoBacenDataExpected, responseRestricaoBacenDataActual);
    }

    @Test
    @DisplayName("Should throw Runtime type Exception")
    void lancaExceptionAoConsultarRestricaoBacenCpf() {
        when(bacenDataSource.consultarRestricaoBacen(Mockito.isA(String.class))).thenThrow(new NotFoundException());
        Assertions.assertThrows(RuntimeException.class, ()-> bacenDataSource.consultarRestricaoBacen(cpf));
    }
}