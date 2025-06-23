package com.jk.jktech.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jk.jktech.entities.Document;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	
    List<Document> findByAuthor(String author);
    List<Document> findByType(String type);
    List<Document> findByContentContainingIgnoreCase(String keyword);
}

