package com.sevenine.conecta.repository.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class Pais {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo", length = 5)
    private String codigo;

    @Column(name = "nome", length = 50)
    private String nome;

}
