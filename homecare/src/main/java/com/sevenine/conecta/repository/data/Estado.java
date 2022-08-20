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
@Table(name = "estado")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class Estado {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo", length = 6)
    private String codigo;

    @Column(name = "uf", length = 2)
    private String uf;

    @Column(name = "nome", length = 20)
    private String nome;

    @Column(name = "regiao", length = 20)
    private String regiao;

}
