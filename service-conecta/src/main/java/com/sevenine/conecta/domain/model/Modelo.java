package com.sevenine.conecta.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Modelo {
    private Long id;
    private String descricao;
    private List<Grupo> grupos;
}
