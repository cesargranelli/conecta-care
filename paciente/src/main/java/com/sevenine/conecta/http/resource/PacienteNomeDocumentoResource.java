package com.sevenine.conecta.adapter.controller.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PacienteNomeDocumentoResource {
    private final Long id;
    private final String nomeCompleto;
    private final String cpf;
}
