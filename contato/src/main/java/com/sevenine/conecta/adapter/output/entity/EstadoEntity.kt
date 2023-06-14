package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "estado")
@Entity(name = "Estado")
data class EstadoEntity(
        @Id
        val id: Long,
        val codigo: Int,
        val uf: String,
        val nome: String,
        val regiao: String,
)
