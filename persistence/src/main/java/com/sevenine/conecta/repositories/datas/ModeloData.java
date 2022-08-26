package com.sevenine.conecta.repositories.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table(name = "modelo")
@Entity(name = "Modelo")
public class ModeloData {

    @Id
    private Long id;

    private String descricao;

    @OneToMany
    private List<GrupoData> grupoData;

}
