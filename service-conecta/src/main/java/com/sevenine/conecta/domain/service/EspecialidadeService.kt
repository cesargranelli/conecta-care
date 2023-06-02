package com.sevenine.conecta.domain.service

import com.sevenine.conecta.domain.model.Especialidade
import com.sevenine.conecta.domain.port.persistence.DominioPersistencePort
import org.springframework.stereotype.Service

@Service
class EspecialidadeService(private val persistence: DominioPersistencePort) {

    fun lista(): List<Especialidade> {
        return persistence.lista()
    }

}