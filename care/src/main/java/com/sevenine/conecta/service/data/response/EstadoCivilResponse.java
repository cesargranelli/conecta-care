package com.sevenine.conecta.services.data.response;

import com.sevenine.conecta.enumerator.TipoEstadoCivilEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoCivilResponse {
    private Long id;
    private TipoEstadoCivilEnum tipo;
    private String descricao;
}
