package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtendimentoPacienteResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private ContatoResponse contato;
}
