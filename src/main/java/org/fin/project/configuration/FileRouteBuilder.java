package org.fin.project.configuration;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileRouteBuilder extends RouteBuilder {
    @Value("${finProject.path}")
    private String pathToFile;
    @Override
    public void configure() throws Exception {
        String url = "activemq:queue:FILE.OUTPUT";
        String path = "file://" + pathToFile + "?delete=true";
        from(path)
                //.routeId("fileInputRoute")
                //.setHeader("JAVA", constant("Hello"))
                //.process("fileProcessor")
                //.process("registerProcessor")
                .to(url)
                .stop();
    }
}
