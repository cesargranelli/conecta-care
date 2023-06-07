package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "modelo")
@Entity(name = "Modelo")
data class ModeloEntity(
        @Id
        val id: Long,
        val descricao: String,
        @OneToMany
        val gruposEntity: List<GrupoEntity>,
)
