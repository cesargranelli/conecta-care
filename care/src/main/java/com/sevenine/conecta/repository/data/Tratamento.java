
package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Table(name = "tratamentos")
@Entity
public class Tratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal valorKilometragem;
    private Long pacienteId;
    private Long acompanhanteId;
    private Long profissionalId;
    private Long homeCareId;

    @OneToMany
    @JoinTable(
            name = "tratamentos_situacao",
            joinColumns = @JoinColumn(name = "tratamento_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<TratamentoSituacao> situacoes;

    @OneToMany
    @JoinTable(
            name = "atendimentos",
            joinColumns = @JoinColumn(name = "tratamento_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Atendimento> atendimentos;

    private String observacao;

}
