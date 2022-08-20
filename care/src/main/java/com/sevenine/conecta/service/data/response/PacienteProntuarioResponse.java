package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteProntuarioResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;
    private GeneroResponse genero;
    private EstadoCivilResponse estadoCivil;
    private ContatoResponse contato;
}
