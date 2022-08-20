package com.sevenine.conecta.controller.data.response;

import com.sevenine.conecta.repository.data.PlanoSaude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PlanoSaudeResponse {
    private final Long id;
    private final String nome;
    private final String cnpj;
    private final Integer anoFundacao;
    private final String tipoDocumento;
    private final List<EspecialidadeResponse> especialidades;
    private final PlanoSaude planoSaudeMatriz;
}
