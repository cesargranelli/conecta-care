package com.sevenine.conecta.controllers.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoResponse {
    private Long id;
    private String codigo;
    private String uf;
    private String nome;
    private String regiao;
}
