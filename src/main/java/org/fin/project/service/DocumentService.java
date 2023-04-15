package org.fin.project.service;

import org.apache.camel.Exchange;
import org.fin.project.entity.Document;

public interface DocumentService {

    void registerDocument(Exchange exchange);

    void delete(Document document);
}
