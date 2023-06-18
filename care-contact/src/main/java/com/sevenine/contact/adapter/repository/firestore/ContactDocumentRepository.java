package com.sevenine.contact.adapter.repository.firestore;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import com.sevenine.contact.adapter.repository.firestore.document.ContactDocument;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDocumentRepository extends FirestoreReactiveRepository<ContactDocument> {
}
