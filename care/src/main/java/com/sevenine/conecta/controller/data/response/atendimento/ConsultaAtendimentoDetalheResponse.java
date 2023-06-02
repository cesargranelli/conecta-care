package com.sevenine.conecta.adapter.controller.data.response.atendimento;

import com.sevenine.conecta.services.data.response.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ConsultaAtendimentoDetalheResponse {
    private Long id;
    private LocalDateTime dataHora;
    private String protocolo;
    private String observacao;
    private EnderecoResponse endereco;
    private PlantonistaResponse plantonista;
    private AcompanhanteResponse acompanhante;
    private AtendimentoDetalheProfissionalResponse profissional;
    private RecorrenciaResponse recorrencia;
    private BigDecimal valorHomeCare;
    private BigDecimal valorProfissional;
    private BigDecimal valorPaciente;
    private BigDecimal valorAjudaCusto;
    private List<GrupoResponse> grupos;
    private TipoAtendimentoResponse tipoAtendimento;
}
