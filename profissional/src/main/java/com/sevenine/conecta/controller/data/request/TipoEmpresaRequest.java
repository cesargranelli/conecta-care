package com.sevenine.conecta.adapter.controller.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoEmpresaRequest {
    private Long id;
    private String sigla;
    private String tipo;
    private String descricao;
}
