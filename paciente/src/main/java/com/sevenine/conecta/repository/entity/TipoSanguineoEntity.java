package com.sevenine.conecta.repository.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_sanguineo")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class TipoSanguineoEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo", length = 30)
    private String tipo;

}
