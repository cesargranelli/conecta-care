package com.sevenine.conecta.controller.data.response.tratamento;

import com.sevenine.conecta.service.data.response.EspecialidadeResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConsultaTratamentoProfissionalResponse {
    private Long id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String conselho;
    private String registro;
    private String celular;
    private List<EspecialidadeResponse> especialidades;
}
