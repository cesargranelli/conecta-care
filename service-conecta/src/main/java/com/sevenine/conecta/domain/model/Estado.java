package com.sevenine.conecta.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estado {
    private Long id;
    private Integer codigo;
    private String uf;
    private String nome;
    private String regiao;
}
