package com.jk.jktech.controllers;


import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.jk.jktech.entities.Document;
import com.jk.jktech.services.DocumentService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    private final Tika tika = new Tika();

    @PostMapping("/upload")
    public Document uploadFile(@RequestParam("file") MultipartFile file,
                               @RequestParam("title") String title,
                               @RequestParam("author") String author) throws IOException {
        String content = "";
		try {
			content = tika.parseToString(file.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		} 

        Document document = new Document();
        document.setTitle(title);
        document.setAuthor(author);
        document.setUploadDate(new Date());
        document.setType(file.getContentType());
        document.setContent(content);

        return documentService.saveDocument(document);
    }

    @GetMapping
    public List<Document> getDocuments(@RequestParam(required = false) String author,
                                       @RequestParam(required = false) String type) {
        if (author != null) {
            return documentService.findByAuthor(author);
        } else if (type != null) {
            return documentService.findByType(type);
        } else {
            return documentService.findAll();
        }
    }
}
