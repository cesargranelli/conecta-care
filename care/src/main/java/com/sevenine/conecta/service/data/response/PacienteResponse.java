package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;
    private String rg;
    private String rgEmissor;
    private LocalDate dataDataEmissao;
    private String foto;
    private String fotoCpf;
    private GeneroResponse genero;
    private EstadoCivilResponse estadoCivil;
    private EnderecoResponse endereco;
    private ContatoResponse contato;
    private HistoricoMedicoResponse historicoMedico;
}
