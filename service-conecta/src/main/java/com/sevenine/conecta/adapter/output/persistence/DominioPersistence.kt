package com.sevenine.conecta.adapter.output.persistence;

import com.sevenine.conecta.adapter.output.repository.*
import com.sevenine.conecta.domain.model.*
import com.sevenine.conecta.domain.port.persistence.DominioPersistencePort
import com.sevenine.conecta.mapper.Mapper
import org.springframework.stereotype.Service

@Service
class DominioPersistence(
        private val bancoRepository: BancoRepository,
        private val categoriaCnhRepository: CategoriaCnhRepository,
        private val conselhoRepository: ConselhoRepository,
        private val especialidadeRepository: EspecialidadeRepository,
        private val estadoCivilRepository: EstadoCivilRepository,
        private val estadoRepository: EstadoRepository,
        private val generoRepository: GeneroRepository,
        private val grupoRepository: GrupoRepository,
        private val instrucaoRepository: InstrucaoRepository,
        private val modeloRepository: ModeloRepository,
        private val paisRepository: PaisRepository,
        private val parentescoRepository: ParentescoRepository,
        private val tipoContaRepository: TipoContaRepository,
        private val tipoEmpresaRepository: TipoEmpresaRepository,
        private val transporteRepository: TransporteRepository,
        private val mapper: Mapper,
) : DominioPersistencePort {
    override fun listaBancos(): List<Banco> {
        return bancoRepository.findAll().map { bancoEntity ->
            mapper.convertBanco(bancoEntity)
        }
    }

    override fun listaCategoriasCnh(): List<CategoriaCnh> {
        return categoriaCnhRepository.findAll().map { categoriaCnhEntity ->
            mapper.convertCategoriaCnh(categoriaCnhEntity)
        }
    }

    override fun listaConselhos(): List<Conselho> {
        return conselhoRepository.findAll().map { conselhoEntity ->
            mapper.convertConselho(conselhoEntity)
        }
    }

    override fun listaEspecialidades(): List<Especialidade> {
        return especialidadeRepository.findAll().map { especialidadeEntity ->
            mapper.convertEspecialidade(especialidadeEntity)
        }
    }

    override fun listaEstadosCivis(): List<EstadoCivil> {
        return estadoCivilRepository.findAll().map { estadoCivilEntity ->
            mapper.convertEstadoCivil(estadoCivilEntity)
        }
    }

    override fun listaEstados(): List<Estado> {
        return estadoRepository.findAll().map { estadoEntity ->
            mapper.convertEstado(estadoEntity)
        }
    }

    override fun listaGeneros(): List<Genero> {
        return generoRepository.findAll().map { generoEntity ->
            mapper.convertGenero(generoEntity)
        }
    }

    override fun listaGrupos(): List<Grupo> {
        return grupoRepository.findAll().map { grupoEntity ->
            mapper.convertGrupo(grupoEntity)
        }
    }

    override fun listaInstrucoes(): List<Instrucao> {
        return instrucaoRepository.findAll().map { instrucaoEntity ->
            mapper.convertInstrucao(instrucaoEntity)
        }
    }

    override fun listaModelos(): List<Modelo> {
        return modeloRepository.findAll().map { modeloEntity ->
            mapper.convertModelo(modeloEntity)
        }
    }

    override fun listaPaises(): List<Pais> {
        return paisRepository.findAll().map { paisEntity ->
            mapper.convertPais(paisEntity)
        }
    }

    override fun listaParentescos(): List<Parentesco> {
        return parentescoRepository.findAll().map { parentescoEntity ->
            mapper.convertParentesco(parentescoEntity)
        }
    }

    override fun listaTiposConta(): List<TipoConta> {
        return tipoContaRepository.findAll().map { tipoContaEntity ->
            mapper.convertTipoConta(tipoContaEntity)
        }
    }

    override fun listaTiposEsmpresa(): List<TipoEmpresa> {
        return tipoEmpresaRepository.findAll().map { tipoEmpresaEntity ->
            mapper.convertTipoEmpresa(tipoEmpresaEntity)
        }
    }

    override fun listaTransportes(): List<Transporte> {
        return transporteRepository.findAll().map { transporteEntity ->
            mapper.convertTransporte(transporteEntity)
        }
    }
}
