package com.sevenine.conecta.controller.data.response.tratamento;

import com.sevenine.conecta.service.data.response.ContatoResponse;
import com.sevenine.conecta.service.data.response.EnderecoResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ConsultaTratamentoPacienteResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;
    private String genero;
    private ContatoResponse contato;
    private String estadoCivil;
    private EnderecoResponse endereco;
}
