package com.sevenine.conecta.repository.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
