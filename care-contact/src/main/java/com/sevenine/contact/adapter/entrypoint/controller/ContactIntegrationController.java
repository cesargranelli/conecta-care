package com.sevenine.contact.adapter.entrypoint.controller;

import com.sevenine.contact.adapter.repository.firestore.ContactDocumentRepository;
import com.sevenine.contact.adapter.repository.firestore.document.ContactDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/contacts")
@RestController
public class ContactIntegrationController {

    @Autowired
    private ContactDocumentRepository repository;

    @PostMapping("subscribe")
    public void subscribe(@RequestBody ContactDocument document) {
        System.out.println(document);

        System.out.printf("Amount contacts: %s", repository.count().block());
    }

}
