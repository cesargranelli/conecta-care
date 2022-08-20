package com.sevenine.conecta.repository.data;

import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Entity
@Table(name = "estoque")
public class EstoqueData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "data_ultima_compra")
    private LocalDateTime dataUltimaCompra;

    @OneToOne
    private UnidadesMedidaData unidadeMedida;

    @OneToOne(cascade = CascadeType.ALL)
    private MaterialData material;

}
