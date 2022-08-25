package com.sevenine.conecta.services.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HistoricoMedicoResponse {
    private Long id;
    private Boolean carteiraVacinacao;
    private Boolean alergiaMedicamento;
    private String alergiaMedicamentoDescricao;
    private LocalDate dataUltimoTratamento;
    private LocalDate dataUltimoAtendimento;
    private TipoSanguineoResponse tipoSanguineo;
}
