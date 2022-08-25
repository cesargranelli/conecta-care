package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoCivilRequest {
    private Long id;
    private String tipo;
    private String descricao;
}
