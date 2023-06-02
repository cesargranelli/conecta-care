package com.sevenine.conecta.repository.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "transporte")
@Entity(name = "Transporte")
public class TransporteData {

    @Id
    private Long id;

    private String tipo;

}
