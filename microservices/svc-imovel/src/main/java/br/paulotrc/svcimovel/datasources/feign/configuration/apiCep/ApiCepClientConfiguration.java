package br.paulotrc.svcimovel.datasources.feign.configuration.apiCep;

import org.springframework.context.annotation.Bean;

public class ApiCepClientConfiguration {

    @Bean
    public ApiCepErrorDecoder errorDecoder(){
        return new ApiCepErrorDecoder();
    }
}
