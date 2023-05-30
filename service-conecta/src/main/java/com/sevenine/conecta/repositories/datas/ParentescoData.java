package com.sevenine.conecta.repositories.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "parentesco")
@Entity(name = "Parentesco")
public class ParentescoData {

    @Id
    private Long id;

    private String descricao;

}
