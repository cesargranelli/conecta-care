package com.sevenine.conecta.http.resource;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class AcompanhanteResource {
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private GeneroResource genero;
    private ParentescoResource parentesco;
    private ContatoResource contato;
    private Long pacienteId;
}
