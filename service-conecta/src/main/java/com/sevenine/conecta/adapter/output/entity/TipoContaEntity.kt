package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tipo_conta")
@Entity(name = "TipoConta")
data class TipoContaEntity(
        @Id
        val id: Long,
        val codigo: String,
        val descricao: String,
)
