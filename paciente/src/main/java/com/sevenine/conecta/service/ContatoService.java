package com.sevenine.conecta.service;

import com.sevenine.conecta.http.resource.ContatoResource;

public interface ContatoService {

    ContatoResource create(ContatoResource resource);

    ContatoResource find(Long id);

    ContatoResource edit(ContatoResource resource);

}
