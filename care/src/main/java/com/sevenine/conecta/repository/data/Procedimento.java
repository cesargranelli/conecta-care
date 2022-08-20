package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table(name = "procedimentos")
@Entity
public class Procedimento {

    @Id
    private Long id;

    private String descricao;

    @OneToMany
    private List<Medicamento> medicamentos;

    @OneToMany
    private List<Equipamento> equipamentos;

}
