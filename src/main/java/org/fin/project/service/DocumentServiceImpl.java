package org.fin.project.service;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.fin.project.dto.documenttype.DocumentType;
import org.fin.project.entity.Document;
import org.fin.project.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public void registerDocument(Exchange exchange) {
        Document document = new Document();
        Message message = exchange.getIn();
        document.setOriginalFileName(message.getHeader("CamelFileName", String.class));
        Long timestamp = message.getHeader("CamelMessageTimestamp", Long.class);
        document.setDate(new Date(timestamp));
        document.setDocumentType(DocumentType.INPUT);
        document.setCommentary("");

        documentRepository.save(document);

    }

    @Override
    public void delete(Document document) {
        documentRepository.delete(document);
    }
}
