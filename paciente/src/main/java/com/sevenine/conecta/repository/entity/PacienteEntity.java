package com.sevenine.conecta.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Paciente")
@Table(name = "paciente")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class PacienteEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "rg")
    private String rg;

    @Column(name = "rg_emissor")
    private String rgEmissor;

    @Column(name = "rg_data_emissao")
    private LocalDate rgDataEmissao;

    @Column(name = "foto")
    private String foto;

    @Column(name = "foto_rg")
    private String fotoRg;

    @Column(name = "foto_cpf")
    private String fotoCpf;

    @OneToOne
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

    @OneToOne
    @JoinColumn(name = "estado_civil_id")
    private EstadoCivilEntity estadoCivil;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @OneToOne
    @JoinColumn(name = "contato_id")
    private ContatoEntity contato;

    @OneToOne
    @JoinColumn(name = "historico_medico_id")
    private HistoricoMedicoEntity historicoMedico;

}
