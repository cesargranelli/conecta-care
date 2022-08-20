package com.sevenine.conecta.service.data.response;

import static java.util.Objects.isNull;

import com.sevenine.conecta.repository.data.AtendimentoSituacao;
import com.sevenine.conecta.repository.data.StatusAtendimento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfissionalAtendimentoResponse {
    private Long id;
    private String tipo;
    private LocalDate data;
    private LocalTime hora;
    private String protocolo;
    private String observacao;
    private String observacoesBaixa;
    private EnderecoResponse endereco;
    private List<GrupoResponse> grupos;
    private List<AtendimentoSituacaoResponse> situacoes;
    private AtendimentoPacienteResponse paciente;
    private AtendimentoAcompanhanteResponse acompanhante;
    private AtendimentoProfissionalResponse profissional;
    private String assinatura;
    
    @JsonIgnore
    public StatusAtendimentoResponse statusRecente() {
        if (isNull(situacoes) || situacoes.isEmpty()) return null;
        return situacoes.stream().max(Comparator.comparing(AtendimentoSituacaoResponse::getDataHora))
                .orElse(new AtendimentoSituacaoResponse()).getStatus();
    }
    
}
