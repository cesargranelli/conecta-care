package com.sevenine.contact.adapter.repository.firestore.document;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collectionName = "contacts")
public class ContactDocument {

    @DocumentId
    private String cpf;

    private String name;
    private String lastName;
    private String email;
    private String cellPhone;

}
