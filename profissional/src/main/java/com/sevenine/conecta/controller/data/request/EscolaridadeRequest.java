package com.sevenine.conecta.controllers.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EscolaridadeRequest {
    private InstrucaoRequest instrucao;
    private List<String> instituicaoEnsino;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private List<String> anoConclusao;

    private Long proprietarioId;
}
