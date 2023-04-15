package org.fin.project.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.Map;

public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        Map<String, Object> headers = exchange.getIn().getHeaders();
        headers.put("HELLO", "JAVA");
        byte[] body = exchange.getIn().getBody(byte[].class);
        String s = new String(exchange.getIn().getBody(byte[].class));
    }
}
