package com.sevenine.conecta.controller.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConsultaModeloResponse {
    private Integer id;
    private String descricao;
    private List<ConsultaGrupoResponse> grupos;
}
