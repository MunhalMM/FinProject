package org.fin.project.controller;

import org.apache.camel.Exchange;
import org.fin.project.entity.Document;
import org.fin.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;


    @PostMapping
    public void create(@RequestBody Exchange exchange) {
        documentService.registerDocument(exchange);
    }

    @DeleteMapping
    public void delete(@RequestBody Document document) {
        documentService.delete(document);
    }
}
