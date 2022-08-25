package com.sevenine.conecta.controllers.data.response;

import com.sevenine.conecta.enumerator.StatusCadastro;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CadastraDocumentoResponse {
    private final Long id;
    private final StatusCadastro status;
}
