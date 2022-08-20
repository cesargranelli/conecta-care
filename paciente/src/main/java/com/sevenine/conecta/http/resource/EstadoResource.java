package com.sevenine.conecta.http.resource;

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
