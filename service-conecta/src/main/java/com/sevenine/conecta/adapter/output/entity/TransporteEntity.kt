package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "transporte")
@Entity(name = "Transporte")
data class TransporteEntity(
        @Id
        val id: Long,
        val tipo: String,
)
