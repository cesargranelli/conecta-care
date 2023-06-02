package com.sevenine.conecta.adapter.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampoRequest {
    private Long id;
    private String descricao;
    private String tipo;
    private String tamanho;
    private String padrao;
    private String obrigatorio;
}
