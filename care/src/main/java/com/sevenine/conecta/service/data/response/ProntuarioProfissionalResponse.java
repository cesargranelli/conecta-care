package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProntuarioProfissionalResponse {
    private Long id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String conselho;
    private String registro;
    private String celular;
    private List<EspecialidadeResponse> especialidades;
}
