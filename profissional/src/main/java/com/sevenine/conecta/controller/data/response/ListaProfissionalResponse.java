package com.sevenine.conecta.controller.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListaProfissionalResponse {
    private Long id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String foto;
    private String conselho;
    private String conselhoUf;
    private String registro;
    private List<ListaEspecialidadeResponse> especialidades;
    private String celular;
}
