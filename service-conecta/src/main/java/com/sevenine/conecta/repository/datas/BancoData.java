package com.sevenine.conecta.repository.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "banco")
@Entity(name = "Banco")
public class BancoData {

    @Id
    private Long id;

    private String codigo;
    private String descricao;

}
