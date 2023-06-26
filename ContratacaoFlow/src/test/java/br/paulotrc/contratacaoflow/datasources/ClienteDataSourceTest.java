package br.paulotrc.contratacaoflow.datasources;

import br.paulotrc.contratacaoflow.datasources.feign.ClienteClient;
import br.paulotrc.contratacaoflow.entities.cliente.ResponseClienteData;
import br.paulotrc.contratacaoflow.exceptions.http.NotFoundException;
import br.paulotrc.contratacaoflow.fixtures.ResponseClienteDataFixture;
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
class ClienteDataSourceTest {

    @InjectMocks
    ClienteDataSource clienteDataSource;

    @Mock
    ClienteClient clienteClient;
    final String cpf = "47742788233";

    @Test
    @DisplayName("Should search customer using customer document Cpf")
    void consultarRestricaoBacenCpf() {
        ResponseClienteData responseClienteDataActual = ResponseClienteDataFixture.gerarCliente();
        when(clienteDataSource.consultarCliente(Mockito.isA(String.class))).thenReturn(List.of(responseClienteDataActual));
        ResponseClienteData responseClienteDataExpected = clienteDataSource.consultarCliente(cpf).get(0);
        Assertions.assertNotNull(responseClienteDataExpected);
        Assertions.assertEquals(responseClienteDataExpected, responseClienteDataActual);
    }

    @Test
    @DisplayName("Should throw Runtime type Exception")
    void lancaExceptionAoConsultarRestricaoBacenCpf() {
        when(clienteDataSource.consultarCliente(Mockito.isA(String.class))).thenThrow(new NotFoundException());
        Assertions.assertThrows(RuntimeException.class, ()-> clienteDataSource.consultarCliente(cpf));
    }
}