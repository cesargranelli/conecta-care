package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tipo_empresa")
@Entity(name = "TipoEmpresa")
data class TipoEmpresaEntity(
        @Id
        val id: Long,
        val sigla: String,
        val tipo: String,
        val descricao: String,
)
