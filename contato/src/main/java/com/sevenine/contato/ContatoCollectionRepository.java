package com.sevenine.contato;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoCollectionRepository extends FirestoreReactiveRepository<ContatoCollection> {
}
