package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "instrucao")
@Entity(name = "Instrucao")
data class InstrucaoEntity(
        @Id
        val id: Long,
        val grau: String,
)
