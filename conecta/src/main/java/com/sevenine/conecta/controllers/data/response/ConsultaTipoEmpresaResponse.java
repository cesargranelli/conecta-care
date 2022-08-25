package com.sevenine.conecta.controllers.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaTipoEmpresaResponse {
    private Integer id;
    private String sigla;
    private String tipo;
    private String descricao;
}
