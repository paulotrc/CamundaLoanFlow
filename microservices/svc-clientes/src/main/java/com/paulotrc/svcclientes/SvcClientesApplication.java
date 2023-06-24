package com.paulotrc.svcclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SvcClientesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvcClientesApplication.class, args);
    }

}
