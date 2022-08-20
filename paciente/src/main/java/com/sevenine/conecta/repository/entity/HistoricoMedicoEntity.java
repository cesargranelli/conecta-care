package com.sevenine.conecta.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historico_medico")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class HistoricoMedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "carteira_vacinacao")
    private Boolean carteiraVacinacao;

    @Column(name = "alergia_medicamento")
    private Boolean alergiaMedicamento;

    @Column(name = "alergia_medicamento_descricao")
    private String alergiaMedicamentoDescricao;

    @Column(name = "data_ultimo_tratamento")
    private LocalDate dataUltimoTratamento;

    @Column(name = "data_ultimo_atendimento")
    private LocalDate dataUltimoAtendimento;

    @ManyToOne
    @JoinColumn(name = "tipo_sanguineo_id")
    private TipoSanguineoEntity tipoSanguineo;

}
