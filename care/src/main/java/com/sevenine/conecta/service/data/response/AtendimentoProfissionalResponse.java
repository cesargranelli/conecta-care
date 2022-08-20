package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AtendimentoProfissionalResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String foto;
    private String conselho;
    private String conselhoUf;
    private String registro;
    private List<EspecialidadeResponse> especialidades;
    private String celular;
    private ContatoResponse contato;
    private String fotoAssinatura;
}
