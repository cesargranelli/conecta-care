package com.sevenine.conecta.mapper.impl

import com.sevenine.conecta.adapter.output.entity.EspecialidadeEntity
import com.sevenine.conecta.domain.model.Especialidade
import com.sevenine.conecta.mapper.Mapper
import org.springframework.stereotype.Component

@Component
class EspecialidadeMapper : Mapper<EspecialidadeEntity, Especialidade> {
    override fun convert(entry: EspecialidadeEntity): Especialidade {
        return Especialidade(entry.id, entry.nome)
    }
}