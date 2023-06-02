package com.sevenine.conecta.adapter.controller.resource;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PacienteRequestResource {

    private final Long id;

    private final String nome;

    private final String sobrenome;

    private final String cpf;

    private final LocalDate dataNascimento;

    private final String rg;

    private final String rgEmissor;

    private final LocalDate rgDataEmissao;

    private final String foto;

    private final String fotoRg;

    private final String fotoCpf;

    private final Long genero;

    private final Long estadoCivil;
}
