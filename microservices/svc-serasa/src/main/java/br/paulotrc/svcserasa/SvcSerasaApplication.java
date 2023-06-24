package br.paulotrc.svcserasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SvcSerasaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvcSerasaApplication.class, args);
    }

}
