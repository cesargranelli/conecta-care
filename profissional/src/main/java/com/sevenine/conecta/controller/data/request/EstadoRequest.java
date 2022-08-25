package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoRequest {
    private Long id;
    private String codigo;
    private String uf;
    private String nome;
    private String regiao;
}
