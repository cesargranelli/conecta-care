package com.sevenine.conecta.services.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AcompanhanteResponse {
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private GeneroResponse genero;
    private ParentescoResponse parentesco;
    private ContatoResponse contato;
}
