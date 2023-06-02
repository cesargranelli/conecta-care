package com.sevenine.conecta.adapter.controller.resource;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class EstadoResource {

    private Long id;

    private String codigo;

    private String uf;

    private String nome;

    private String regiao;

}
