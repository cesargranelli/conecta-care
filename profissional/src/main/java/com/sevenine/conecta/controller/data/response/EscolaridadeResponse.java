package com.sevenine.conecta.controllers.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EscolaridadeResponse {
    private Long id;
    private InstrucaoResponse instrucao;
    private List<String> instituicaoEnsino;
    private List<String> anoConclusao;
}
