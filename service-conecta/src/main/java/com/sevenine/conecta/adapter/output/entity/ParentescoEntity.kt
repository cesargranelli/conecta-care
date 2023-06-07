package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "parentesco")
@Entity(name = "Parentesco")
data class ParentescoEntity(
        @Id
        val id: Long,
        val descricao: String,
)
