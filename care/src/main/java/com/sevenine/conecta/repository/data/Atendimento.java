
package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

import static java.util.Objects.isNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(name = "atendimentos")
@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private LocalTime hora;

    private String observacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @Column(name = "tratamento_id")
    private Long tratamentoId;

    private Long plantonistaId;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Recorrencia recorrencia;

    private Long profissionalId;

    @OneToOne(cascade = CascadeType.ALL)
    private Procedimento procedimento;

    private BigDecimal valorHomeCare;
    private BigDecimal valorProfissional;
    private BigDecimal valorPaciente;
    private BigDecimal valorAjudaCusto;
    private Long homeCareId;
    private Long pacienteId;
    private String codigoSeguranca;
    private String observacoesBaixa;
    private String assinatura;

    @OneToMany
    @JoinTable(
            name = "atendimentos_grupos",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "grupos_id")
    )
    private List<Grupo> grupos;

    @OneToMany
    @JoinTable(
            name = "atendimentos_situacao",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<AtendimentoSituacao> situacoes;

    @OneToMany
    @JoinTable(
            name = "atendimentos_campos_baixa",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<AtendimentoCampoBaixa> campos;

    public String geraCodigoSeguranca() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(UUID.randomUUID().toString().getBytes());
            return stringHexa(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String stringHexa(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            int valueInteger = Integer.signum(aByte) == -1 ? aByte * -1 : aByte;
            String hexString = Integer.toHexString(valueInteger > 99 ? valueInteger / 10 : valueInteger);
            String hexStringLeftPad = StringUtils.leftPad(hexString, 2, "0");
            stringBuilder.append(hexStringLeftPad).append(".");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1).toString().toUpperCase();
    }

    @JsonIgnore
    public StatusAtendimento statusRecente() {
        if (isNull(situacoes) || situacoes.isEmpty()) return null;
        return situacoes.stream().max(Comparator.comparing(AtendimentoSituacao::getDataHora))
                .orElse(new AtendimentoSituacao()).getStatus();
    }
    
    @ManyToOne
    private Especialidade tipoAtendimento;

}
