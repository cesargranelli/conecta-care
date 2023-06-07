package com.sevenine.conecta.mapper.impl

import com.sevenine.conecta.adapter.output.entity.*
import com.sevenine.conecta.domain.model.*
import com.sevenine.conecta.mapper.Mapper
import org.springframework.stereotype.Component

@Component
class DominioMapper : Mapper {
    override fun convertBanco(entry: BancoEntity): Banco {
        return Banco(entry.id, entry.codigo, entry.descricao)
    }

    override fun convertCategoriaCnh(entry: CategoriaCnhEntity): CategoriaCnh {
        return CategoriaCnh(entry.id, entry.sigla, entry.descricao)
    }

    override fun convertConselho(entry: ConselhoEntity): Conselho {
        return Conselho(entry.id, entry.sigla, entry.descricao)
    }

    override fun convertEspecialidade(entry: EspecialidadeEntity): Especialidade {
        return Especialidade(entry.id, entry.nome)
    }

    override fun convertEstadoCivil(entry: EstadoCivilEntity): EstadoCivil {
        return EstadoCivil(entry.id, entry.tipo, entry.descricao)
    }

    override fun convertEstado(entry: EstadoEntity): Estado {
        return Estado(entry.id, entry.codigo, entry.uf, entry.nome, entry.regiao)
    }

    override fun convertGenero(entry: GeneroEntity): Genero {
        return Genero(entry.id, entry.codigo, entry.descricao)
    }

    override fun convertGrupo(entry: GrupoEntity): Grupo {
        return Grupo(entry.id, entry.descricao)
    }

    override fun convertInstrucao(entry: InstrucaoEntity): Instrucao {
        return Instrucao(entry.id, entry.grau)
    }

    override fun convertModelo(entry: ModeloEntity): Modelo {
        return Modelo(entry.id, entry.descricao, entry.gruposEntity.map { grupoEntity ->
            convertGrupo(grupoEntity)
        })
    }

    override fun convertPais(entry: PaisEntity): Pais {
        return Pais(entry.id, entry.codigo, entry.nome)
    }

    override fun convertParentesco(entry: ParentescoEntity): Parentesco {
        return Parentesco(entry.id, entry.descricao)
    }

    override fun convertTipoConta(entry: TipoContaEntity): TipoConta {
        return TipoConta(entry.id, entry.codigo, entry.descricao)
    }

    override fun convertTipoEmpresa(entry: TipoEmpresaEntity): TipoEmpresa {
        return TipoEmpresa(entry.id, entry.sigla, entry.tipo, entry.descricao)
    }

    override fun convertTransporte(entry: TransporteEntity): Transporte {
        return Transporte(entry.id, entry.tipo)
    }
}