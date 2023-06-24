package br.paulotrc.svcimovel.repositories;

import br.paulotrc.svcimovel.entites.feign.ResponseApiCepData;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

public interface ApiCepRepository {

    @CircuitBreaker(name = "processServiceApiCep", fallbackMethod = "fallback")
    @Retry(name = "default")
    ResponseApiCepData consultarPorCep(String cep);
}
