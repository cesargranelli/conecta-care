package com.sevenine.conecta.adapter.controller.resource;

import com.sevenine.conecta.repository.entity.TipoSanguineoEntity;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class HistoricoMedicoResource {

    private Long id;

    private Boolean carteiraVacinacao;

    private Boolean alergiaMedicamento;

    private String alergiaMedicamentoDescricao;

    private LocalDate dataUltimoTratamento;

    private LocalDate dataUltimoAtendimento;

    private TipoSanguineoEntity tipoSanguineo;

}
