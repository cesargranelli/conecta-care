package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "pais")
@Entity(name = "Pais")
data class PaisEntity(
        @Id
        val id: Long,
        val codigo: String,
        val nome: String,
)
