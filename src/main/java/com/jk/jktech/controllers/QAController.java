package com.jk.jktech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jk.jktech.entities.Document;
import com.jk.jktech.services.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/qa")
public class QAController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/search")
    public List<Document> searchDocuments(@RequestParam String query) {
        return documentService.searchDocuments(query);
    }
}

