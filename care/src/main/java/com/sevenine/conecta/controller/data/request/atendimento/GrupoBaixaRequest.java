package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GrupoBaixaRequest {
    private Long grupoId;
    private String descricao;
    private List<String> fotos;
    private List<SubgrupoBaixaRequest> subgrupos;
}
