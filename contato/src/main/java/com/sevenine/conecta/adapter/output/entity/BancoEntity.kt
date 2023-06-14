package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "banco")
@Entity(name = "Banco")
data class BancoEntity(
        @Id
        val id: Long,
        val codigo: String,
        val descricao: String,
)
