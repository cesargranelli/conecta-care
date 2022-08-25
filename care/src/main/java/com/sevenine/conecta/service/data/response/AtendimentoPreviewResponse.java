package com.sevenine.conecta.services.data.response;

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
public class AtendimentoPreviewResponse {
    
    private Long id;
    private String protocolo;

    private Long profissionalId;
    private String profissionalNome;
    private String profissionalCpf;
    
    private String tipoAtendimentoId;
    private String tipoAtendimentoNome;
    
    private Long pacienteId;
    private String pacienteNome;
    private String pacienteCpf;

    private LocalDate data;
    private LocalTime hora;

    private String statusAtendimentoId;
    private String statusAtendimentoDescricao;
    
    private String observacao;

    private Long homeCareId;
    private String homeCareNome;
    
    private BigDecimal valorHomeCare;
    private BigDecimal valorProfissional;
    private BigDecimal valorPaciente;
    private BigDecimal valorAjudaCusto;
    

    public Boolean equalsProfissional(String profissionalCpf) {
        return isNull(profissionalCpf) || StringUtils.isBlank(profissionalCpf) ? true
                : Objects.equals(profissionalCpf.toString(), this.profissionalCpf.toString()); 
    }
    
    public Boolean equalsPaciente(String pacienteCpf) {
        return isNull(pacienteCpf) || StringUtils.isBlank(pacienteCpf) ? true
                : Objects.equals(pacienteCpf.toString(), this.pacienteCpf.toString()); 
    }

    public Boolean equalsStatus(String statusAtendimentoId) {
        return isNull(statusAtendimentoId) || StringUtils.isBlank(statusAtendimentoId) ? true
                : Objects.equals(statusAtendimentoId.toString(), this.statusAtendimentoId.toString()); 
    }

    public Boolean equalsAtendimento(String tipoAtendimentoId) {
        return isNull(tipoAtendimentoId) || StringUtils.isBlank(tipoAtendimentoId) ? true
                : Objects.equals(tipoAtendimentoId.toString(), this.tipoAtendimentoId.toString()); 
    }
    
}
