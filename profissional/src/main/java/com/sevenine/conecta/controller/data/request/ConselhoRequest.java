package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConselhoRequest {
    private Long id;
    private String descricao;
    private String sigla;
}
