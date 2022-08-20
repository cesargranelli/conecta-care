package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "status_tratamento")
@Entity
public class StatusTratamento {

    @Id
    private Long id;

    private String descricao;

}
