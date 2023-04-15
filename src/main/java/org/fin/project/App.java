package org.fin.project;

import org.fin.project.configuration.FinConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FinConfiguration.class)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);

    }
}
