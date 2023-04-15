package org.fin.project.configuration;

import org.fin.project.processors.FileProcessor;
import org.fin.project.processors.RegisterProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinConfiguration {

    @Bean
    public FileProcessor fileProcessor() {
        return new FileProcessor();
    }

    @Bean
    public RegisterProcessor registerProcessor() {
        return new RegisterProcessor();
    }
}
