package com.connecta.evento.repository.entity;

import com.connecta.evento.enumerator.EventoStatus;
import com.connecta.evento.service.state.EventoState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Table(name = "eventos")
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String descricao;
    private String detalhe;
    private LocalDate data;
    private LocalTime hora;
    private LocalDateTime dataCadastro;
    private String usuarioCadastro;
    private LocalDateTime dataAtualizacao;
    private String usuarioAtualizacao;
    private String logradouro;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private int duracao;
    private int vagas;

    @Enumerated(EnumType.STRING)
    private EventoStatus status;

    @ManyToOne
    @JoinTable(
            name = "eventos_estado",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "estado_id")
    )
    private Estado estado;

    @ManyToMany(targetEntity = Especialidade.class)
    @JoinTable(
            name = "eventos_area_atendimento",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "area_atendimento_id")
    )
    private List<Especialidade> especialidades;

    public void classificaStatus(EventoState state) {
        setStatus(state.classificaStatus(this));
    }

}
