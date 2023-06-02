package com.sevenine.conecta.adapter.controller.data.request;

import com.sevenine.conecta.repository.data.PlanoSaude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlanoSaudeRequest {
    private Long id;
    private String nome;
    private String cnpj;
    private Integer anoFundacao;
    private String tipoDocumento;
    private List<EspecialidadeRequest> especialidades;
    private PlanoSaude planoSaudeMatriz;
}
