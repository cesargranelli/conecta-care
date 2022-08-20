package com.sevenine.conecta.service.data.response;

import com.sevenine.conecta.enumerator.GeneroEnum;
import com.sevenine.conecta.enumerator.TipoGeneroEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneroResponse {
    private Long id;
    private TipoGeneroEnum tipo;
    private GeneroEnum descricao;
}
