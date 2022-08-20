package com.sevenine.conecta.repository.data;

import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Table(name = "materiais")
public class MaterialData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "codigo_barras", nullable = true)
    private String codigoBarras;

    @Column(name = "foto")
    private String foto;

    @OneToOne
    private CategoriaData categoria;

    @OneToOne
    private SubCategoriaData subCategoria;

    @OneToOne(cascade = CascadeType.ALL)
    private LocacaoData locacao;

    @OneToOne(cascade = CascadeType.ALL)
    private VendaData venda;

}
