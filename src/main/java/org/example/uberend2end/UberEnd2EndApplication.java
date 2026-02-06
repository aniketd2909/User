package org.example.uberend2end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class UberEnd2EndApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberEnd2EndApplication.class, args);
    }

}
