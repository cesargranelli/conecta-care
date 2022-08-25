package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.resource.EnderecoResource;

public interface EnderecoService {

    EnderecoResource create(EnderecoResource resource);

    EnderecoResource findByIdPaciente(Long idPaciente);

    EnderecoResource findById(Long id);

    EnderecoResource edit(EnderecoResource resource);

}
