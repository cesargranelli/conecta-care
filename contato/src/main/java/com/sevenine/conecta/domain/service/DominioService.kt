package com.sevenine.conecta.domain.service

import com.sevenine.conecta.domain.model.*
import com.sevenine.conecta.domain.port.persistence.DominioPersistencePort
import com.sevenine.conecta.domain.port.service.DominioServicePort
import org.springframework.stereotype.Service

@Service
class DominioService(private val persistence: DominioPersistencePort) : DominioServicePort {
    override fun listaBancos(): List<Banco> {
        return persistence.listaBancos()
    }

    override fun listaCategoriasCnh(): List<CategoriaCnh> {
        return persistence.listaCategoriasCnh()
    }

    override fun listaConselhos(): List<Conselho> {
        return persistence.listaConselhos()
    }

    override fun listaEspecialidades(): List<Especialidade> {
        return persistence.listaEspecialidades()
    }

    override fun listaEstadosCivis(): List<EstadoCivil> {
        return persistence.listaEstadosCivis()
    }

    override fun listaEstados(): List<Estado> {
        return persistence.listaEstados()
    }

    override fun listaGeneros(): List<Genero> {
        return persistence.listaGeneros()
    }

    override fun listaGrupos(): List<Grupo> {
        return persistence.listaGrupos()
    }

    override fun listaInstrucoes(): List<Instrucao> {
        return persistence.listaInstrucoes()
    }

    override fun listaModelos(): List<Modelo> {
        return persistence.listaModelos()
    }

    override fun listaPaises(): List<Pais> {
        return persistence.listaPaises()
    }

    override fun listaParentescos(): List<Parentesco> {
        return persistence.listaParentescos()
    }

    override fun listaTiposConta(): List<TipoConta> {
        return persistence.listaTiposConta()
    }

    override fun listaTiposEsmpresa(): List<TipoEmpresa> {
        return persistence.listaTiposEsmpresa()
    }

    override fun listaTransportes(): List<Transporte> {
        return persistence.listaTransportes()
    }
}