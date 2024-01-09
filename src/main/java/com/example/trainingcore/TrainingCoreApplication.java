package com.example.trainingcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TrainingCoreApplication {

    public static void main(
            final String[] args
    ) {
        SpringApplication.run(TrainingCoreApplication.class, args);
    }

}
