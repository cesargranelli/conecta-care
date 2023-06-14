package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "genero")
@Entity(name = "Genero")
data class GeneroEntity(
        @Id
        val id: Long,
        val tipo: String,
        val descricao: String,
)
