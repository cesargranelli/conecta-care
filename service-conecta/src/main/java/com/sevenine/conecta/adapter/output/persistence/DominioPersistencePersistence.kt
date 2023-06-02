package com.sevenine.conecta.adapter.output.persistence

import com.sevenine.conecta.adapter.output.entity.EspecialidadeEntity
import com.sevenine.conecta.adapter.output.repository.EspecialidadeRepository
import com.sevenine.conecta.domain.model.Especialidade
import com.sevenine.conecta.domain.port.persistence.DominioPersistencePort
import com.sevenine.conecta.mapper.EspecialidadeMapper
import org.springframework.stereotype.Component

@Component
class DominioPersistencePersistence(
        private val repository: EspecialidadeRepository,
        private val mapper: EspecialidadeMapper<EspecialidadeEntity, Especialidade>,
) : DominioPersistencePort {
    override fun executa(): List<Especialidade> {
        return repository.findAll().map { especialidadeEntity -> mapper.convert(especialidadeEntity) }
    }
}