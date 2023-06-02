package com.sevenine.conecta.adapter.controller.data.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarreiraRequest {
    private Long id;
    private ConselhoRequest conselho;
    private Long registroProfissional;
    private UfConselhoRequest ufConselho;
    private List<AreaAtendimentoRequest> areasAtendimento;
    private String nomeReferencia1;
    private String nomeReferencia2;
    private String telefoneReferencia1;
    private String telefoneReferencia2;
    private TransporteRequest transporte;
    private Long proprietarioId;
}
