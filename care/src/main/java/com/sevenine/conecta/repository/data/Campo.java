package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "campo")
@Entity
public class Campo {

    @Id
    private Long id;

    private String tipo;
    private String tamanho;
    private String pre;
    private String pos;

    @OneToMany
    @JoinTable(
            name = "subgrupo_campos",
            joinColumns = @JoinColumn(name = "campo_id"),
            inverseJoinColumns = @JoinColumn(name = "subgrupo_id")
    )
    private List<Subgrupo> subgrupos;

}
