package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "carreiras")
@Entity
public class Carreira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Conselho conselho;

    @ManyToOne
    @JoinColumn(
            name = "uf_conselho_id",
            referencedColumnName = "id"
    )
    private Estado estado;

    @ManyToOne
    private Transporte transporte;

    private Long registroProfissional;
    private String nomeReferencia1;
    private String nomeReferencia2;
    private String telefoneReferencia1;
    private String telefoneReferencia2;

    @OneToMany
    @JoinTable(
            name = "carreiras_area_atendimento",
            joinColumns = @JoinColumn(name = "carreira_id"),
            inverseJoinColumns = @JoinColumn(name = "area_atendimento_id")
    )
    private List<AreaAtendimento> areasAtendimento;

    @OneToOne
    private Profissional profissional;

}
