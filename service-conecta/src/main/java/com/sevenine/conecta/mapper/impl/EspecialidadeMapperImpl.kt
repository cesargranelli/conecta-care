package com.sevenine.conecta.mapper.impl

import com.sevenine.conecta.adapter.output.entity.EspecialidadeEntity
import com.sevenine.conecta.domain.model.Especialidade
import com.sevenine.conecta.mapper.EspecialidadeMapper
import org.springframework.stereotype.Component

@Component
class EspecialidadeMapperImpl : EspecialidadeMapper<EspecialidadeEntity, Especialidade> {
    override fun convert(entry: EspecialidadeEntity): Especialidade {
        return Especialidade(entry.id, entry.nome)
    }
}