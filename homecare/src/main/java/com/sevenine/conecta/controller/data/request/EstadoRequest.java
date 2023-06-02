package com.sevenine.conecta.adapter.controller.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EstadoRequest {
    private Long id;
    private String codigo;
    private String uf;
    private String nome;
    private String regiao;
}
