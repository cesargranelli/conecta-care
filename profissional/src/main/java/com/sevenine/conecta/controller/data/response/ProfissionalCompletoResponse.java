package com.sevenine.conecta.adapter.controller.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfissionalCompletoResponse {
    private ProfissionalResponse profissional;
    private EnderecoResponse endereco;
    private TelefoneResponse telefone;
    private ContaResponse conta;
    private ComplementoResponse complemento;
    private List<ExperienciaResponse> experiencia;
    private CarreiraResponse carreira;
    private EscolaridadeResponse escolaridade;
}
