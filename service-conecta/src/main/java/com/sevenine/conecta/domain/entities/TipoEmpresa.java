package com.sevenine.conecta.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoEmpresa {
    private Long id;
    private String sigla;
    private String tipo;
    private String descricao;
}
