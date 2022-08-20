package com.sevenine.conecta.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubgrupoBaixaRequest {
    private Long subgrupoId;
    private String descricao;
    private List<CampoBaixaRequest> campos;
}
