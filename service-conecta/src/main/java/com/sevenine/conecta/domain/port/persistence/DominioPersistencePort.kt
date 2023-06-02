package com.sevenine.conecta.domain.port.persistence

import com.sevenine.conecta.domain.model.Especialidade

interface DominioPersistencePort {
    fun lista(): List<Especialidade>
}