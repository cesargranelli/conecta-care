package com.sevenine.conecta.service;

import com.sevenine.conecta.http.resource.EnderecoResource;

public interface EnderecoService {

    EnderecoResource create(EnderecoResource resource);

    EnderecoResource findByIdPaciente(Long idPaciente);

    EnderecoResource findById(Long id);

    EnderecoResource edit(EnderecoResource resource);

}
