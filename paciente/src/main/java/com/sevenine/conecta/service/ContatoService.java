package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.resource.ContatoResource;

public interface ContatoService {

    ContatoResource create(ContatoResource resource);

    ContatoResource find(Long id);

    ContatoResource edit(ContatoResource resource);

}
