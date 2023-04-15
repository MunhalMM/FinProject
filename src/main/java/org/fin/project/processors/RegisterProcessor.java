package org.fin.project.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.fin.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterProcessor implements Processor {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public void process(Exchange exchange) throws Exception {
        //documentService.registerDocument(exchange);
        producerTemplate.send("activemq:queue:FIN.FILE.OUTPUT",exchange);
    }
}
