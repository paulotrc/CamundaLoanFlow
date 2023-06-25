package br.paulotrc.contratacaoflow.datasources.tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.FlowElement;
import org.camunda.bpm.model.xml.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskLoggerTest {

    DelegateExecution execution;

    @Spy
    @InjectMocks
    private TaskLogger taskLogger;

    @Test
    void deve_executar_sem_erro() {

        Map<String, Object> variables = new HashMap<>();
        variables.put("valor_pix","100.00");
        Expression injectedProperty = mock(Expression.class);
        execution = mock(DelegateExecution.class);
        ReflectionTestUtils.setField(taskLogger, "injectedProperty", injectedProperty);

        when(execution.getVariables()).thenReturn(variables);
        when(execution.getCurrentActivityName()).thenReturn("Teste \\n teste");
        when(execution.getProcessInstanceId()).thenReturn("Teste \\n teste");
        when(execution.getProcessBusinessKey()).thenReturn("Teste \\n teste");
        when(execution.getId()).thenReturn("Teste \\n teste");
        when(execution.getBpmnModelInstance()).thenReturn(mock(BpmnModelInstance.class));
        when(execution.getBpmnModelInstance().getModel()).thenReturn(mock(Model.class));
        when(execution.getBpmnModelInstance().getModel().getModelName()).thenReturn("Teste \\n teste");
        when(execution.getBpmnModelElementInstance()).thenReturn(mock(FlowElement.class));
        when(execution.getBpmnModelElementInstance().getId()).thenReturn("Teste \\n teste");

        taskLogger.execute(execution);

        assertEquals(null, execution.getTenantId());
        verify(taskLogger, times(1)).execute(execution);
    }

}