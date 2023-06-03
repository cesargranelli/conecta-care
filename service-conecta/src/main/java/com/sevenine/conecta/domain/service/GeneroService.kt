package com.sevenine.conecta.domain.service

import com.sevenine.conecta.domain.model.Genero
import com.sevenine.conecta.domain.port.persistence.DominioPersistencePort
import com.sevenine.conecta.domain.port.service.DominioServicePort
import org.springframework.stereotype.Service

@Service
class GeneroService(private val persistence: DominioPersistencePort) : DominioServicePort<Genero> {

    override fun lista(): List<Genero> = listOf()
}