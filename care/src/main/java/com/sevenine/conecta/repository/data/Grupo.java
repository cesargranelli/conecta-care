package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "grupo")
@Entity
public class Grupo {

    @Id
    private Long id;

    private String descricao;

    @OneToMany
    @JoinTable(
            name = "grupo_subgrupos",
            joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "subgrupos_id")
    )
    private List<Subgrupo> subgrupos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "modelo_grupos",
            joinColumns = @JoinColumn(name = "grupos_id"),
            inverseJoinColumns = @JoinColumn(name = "modelo_id")
    )
    private Modelo modelo;

}
