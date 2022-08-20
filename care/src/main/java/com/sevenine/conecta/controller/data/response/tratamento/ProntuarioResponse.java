package com.sevenine.conecta.controller.data.response.tratamento;

import com.sevenine.conecta.service.data.response.PacienteProntuarioResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProntuarioResponse {
    private PacienteProntuarioResponse paciente;
    private List<ProntuarioTratamentoResponse> tratamentos;
}
