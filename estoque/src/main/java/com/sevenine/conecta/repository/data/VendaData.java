package com.sevenine.conecta.repository.data;

import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Entity
@Table(name = "venda")
public class VendaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "preco")
    private BigDecimal preco;

    @OneToOne
    private MoedaData moeda;

    @OneToOne(cascade = CascadeType.ALL)
    private PromocaoData promocao;

}
