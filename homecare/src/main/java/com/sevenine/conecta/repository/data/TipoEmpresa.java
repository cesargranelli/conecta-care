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
@Table(name = "tipo_empresa")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class TipoEmpresa {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao", length = 4)
    private String descricao;

}
