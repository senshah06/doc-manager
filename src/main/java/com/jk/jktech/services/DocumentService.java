package com.jk.jktech.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.jktech.entities.Document;
import com.jk.jktech.repositories.DocumentRepository;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> findByAuthor(String author) {
        return documentRepository.findByAuthor(author);
    }

    public List<Document> findByType(String type) {
        return documentRepository.findByType(type);
    }

    public List<Document> searchDocuments(String keyword) {
        return documentRepository.findByContentContainingIgnoreCase(keyword);
    }

    public List<Document> findAll() {
        return documentRepository.findAll();
    }
}
