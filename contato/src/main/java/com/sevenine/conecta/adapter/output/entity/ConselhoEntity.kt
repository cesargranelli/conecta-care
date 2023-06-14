package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "conselho")
@Entity(name = "Conselho")
data class ConselhoEntity(
        @Id
        val id: Long,
        val sigla: String,
        val descricao: String,
)
