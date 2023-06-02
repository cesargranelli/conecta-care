package com.sevenine.conecta.repository.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
