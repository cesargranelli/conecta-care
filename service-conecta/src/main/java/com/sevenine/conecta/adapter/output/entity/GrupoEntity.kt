package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "grupo")
@Entity(name = "Grupo")
data class GrupoEntity(
        @Id
        val id: Long,
        val descricao: String,
)
