package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.resource.PacienteNomeDocumentoResource;
import com.sevenine.conecta.adapter.controller.resource.PacientePesquisaResource;
import com.sevenine.conecta.adapter.controller.resource.PacienteResource;

import java.util.List;

public interface PacienteService {

    PacienteResource create(PacienteResource resource);

    PacienteResource find(Long id);

    PacienteResource edit(PacienteResource resource);

    PacienteResource findByCpf(String cpf);

    List<PacienteNomeDocumentoResource> findByNome(String nome);

    List<PacienteResource> findByListId(List<Long> idsPacientes);

    List<PacientePesquisaResource> getCpfListByName(String nome);
}
