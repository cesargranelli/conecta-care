package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "modelo")
@Entity
public class Modelo {

    @Id
    private Long id;

    private String descricao;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "modelo_grupos",
//            joinColumns = @JoinColumn(name = "modelo_id"),
//            inverseJoinColumns = @JoinColumn(name = "grupos_id")
//    )
//    private List<Grupo> grupos;

}
