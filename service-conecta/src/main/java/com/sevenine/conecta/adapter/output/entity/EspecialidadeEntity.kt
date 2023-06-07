package com.sevenine.conecta.adapter.output.entity

import jakarta.persistence.*

@Table(name = "especialidade")
@Entity(name = "Especialidade")
data class EspecialidadeEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val nome: String
)