package org.example.uberend2end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@EnableMongoAuditing
public class UberEnd2EndApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        ConfigurableApplicationContext ctx = SpringApplication.run(UberEnd2EndApplication.class, args);
        ctx.registerShutdownHook();
        // Optional: Add JVM shutdown hook as backup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("!!! JVM shutdown hook triggered !!!");
            ctx.close();
        }));
    }

}
