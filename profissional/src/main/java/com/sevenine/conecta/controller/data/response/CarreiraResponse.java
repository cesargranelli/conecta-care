package com.sevenine.conecta.controllers.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarreiraResponse {
    private Long id;
    private ConselhoResponse conselho;
    private Long registroProfissional;
    private EstadoResponse ufConselho;
    private List<AreaAtendimentoResponse> areasAtendimento;
    private String nomeReferencia1;
    private String nomeReferencia2;
    private String telefoneReferencia1;
    private String telefoneReferencia2;
    private TransporteResponse transporte;
}
