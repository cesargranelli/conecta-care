package com.sevenine.conecta.services.data.report;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

import static java.util.Objects.isNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
public class AtendimentoPreviewReport {
    
    private Long atendimentoId;
    private String atendimentoTipo;

    private Long pacienteId;
    private String pacienteNome;
    private String pacienteCpf;

    private String dataHora;
    private String status;
    private String observacao;
    private String observacoesBaixa;
    private String protocolo;
    private String checkIn;
    private String checkOut;

    private String profissionalArea;
    private String profissionalNome;
    private String profissionalContato;
    private String profissionalCpf;
    
    private Long grupoId;
    private String grupoNome;
    
    private Long subGrupoId;
    private String subGrupoNome;

    private Long campoId;
    private String campoTipo;
    private String campoPre;
    private String campoPos;
    private String campoBaixa;
    
    //
    private String homeCareId;
    private String homeCareNome;
    
    private String tratamentoId;
    private String tratamentoNome;

    private String enderecoId;
    private String enderecoCep;
    private String enderecoLogradouro;
    private String enderecoNumero;
    private String enderecoComplemento;
    
    private BigDecimal atendmentoValorHC;
    private BigDecimal atendmentoValorProf;
    private BigDecimal atendmentoValorPac;
    private BigDecimal atendmentoValorCusto;
    
    private String assinaturaPacientePath;
    private String assinaturaProfissionalPath;
    
}
