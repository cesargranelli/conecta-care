package com.sevenine.conecta.adapter.controller.data.response.tratamento;

import com.sevenine.conecta.services.data.response.PacienteProntuarioResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProntuarioResponse {
    private PacienteProntuarioResponse paciente;
    private List<ProntuarioTratamentoResponse> tratamentos;
}
