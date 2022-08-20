package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoEmpresaResponse {
    private Long id;
    private String sigla;
    private String tipo;
    private String descricao;
}
