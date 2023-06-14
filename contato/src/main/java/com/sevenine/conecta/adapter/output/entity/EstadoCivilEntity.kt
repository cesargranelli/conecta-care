package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "estado_civil")
@Entity(name = "EstadoCivil")
data class EstadoCivilEntity(
        @Id
        val id: Long,
        val tipo: String,
        val descricao: String,
)
