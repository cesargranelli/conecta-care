package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BaixaRequest {
    private Long atendimentoId;
    private String assinatura;
    private String observacoes;
    private List<String> fotos;
    private List<GrupoBaixaRequest> grupos;
}
