package com.sevenine.conecta.repository.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_civil")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class EstadoCivilEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo", length = 10)
    private String tipo;

    @Column(name = "descricao", length = 255)
    private String descricao;

}
