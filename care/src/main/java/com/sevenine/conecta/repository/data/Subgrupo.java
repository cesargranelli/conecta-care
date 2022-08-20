package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "subgrupo")
@Entity
public class Subgrupo {

    @Id
    private Long id;

    private String descricao;

    @OneToMany
    @JoinTable(
            name = "subgrupo_campos",
            joinColumns = @JoinColumn(name = "subgrupo_id"),
            inverseJoinColumns = @JoinColumn(name = "campos_id")
    )
    private List<Campo> campos;


    }
