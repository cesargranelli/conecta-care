package com.sevenine.conecta.repositories.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "tipo_empresa")
@Entity(name = "TipoEmpresa")
public class TipoEmpresaData {

    @Id
    private Long id;

    private String sigla;
    private String tipo;
    private String descricao;

}
