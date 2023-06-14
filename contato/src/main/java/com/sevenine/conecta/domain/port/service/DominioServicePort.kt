package com.sevenine.conecta.domain.port.service

import com.sevenine.conecta.domain.model.*

interface DominioServicePort {
    fun listaBancos(): List<Banco>
    fun listaCategoriasCnh(): List<CategoriaCnh>
    fun listaConselhos(): List<Conselho>
    fun listaEspecialidades(): List<Especialidade>
    fun listaEstadosCivis(): List<EstadoCivil>
    fun listaEstados(): List<Estado>
    fun listaGeneros(): List<Genero>
    fun listaGrupos(): List<Grupo>
    fun listaInstrucoes(): List<Instrucao>
    fun listaModelos(): List<Modelo>
    fun listaPaises(): List<Pais>
    fun listaParentescos(): List<Parentesco>
    fun listaTiposConta(): List<TipoConta>
    fun listaTiposEsmpresa(): List<TipoEmpresa>
    fun listaTransportes(): List<Transporte>
}