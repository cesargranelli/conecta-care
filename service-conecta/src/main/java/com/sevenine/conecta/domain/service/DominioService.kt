package com.sevenine.conecta.domain.service

import com.sevenine.conecta.domain.model.Especialidade
import com.sevenine.conecta.domain.port.persistence.DominioPersistencePort
import com.sevenine.conecta.domain.port.service.DominioServicePort
import org.springframework.stereotype.Service

@Service
class DominioService(private val persistence: DominioPersistencePort) : DominioServicePort<Especialidade> {

    override fun lista(): List<Especialidade> = persistence.lista()
}