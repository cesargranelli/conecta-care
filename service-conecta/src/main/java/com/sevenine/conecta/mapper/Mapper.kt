package com.sevenine.conecta.mapper

import com.sevenine.conecta.adapter.output.entity.*
import com.sevenine.conecta.domain.model.*

interface Mapper {
    fun convertBanco(entry: BancoEntity): Banco
    fun convertCategoriaCnh(entry: CategoriaCnhEntity): CategoriaCnh
    fun convertConselho(entry: ConselhoEntity): Conselho
    fun convertEspecialidade(entry: EspecialidadeEntity): Especialidade
    fun convertEstadoCivil(entry: EstadoCivilEntity): EstadoCivil
    fun convertEstado(entry: EstadoEntity): Estado
    fun convertGenero(entry: GeneroEntity): Genero
    fun convertGrupo(entry: GrupoEntity): Grupo
    fun convertInstrucao(entry: InstrucaoEntity): Instrucao
    fun convertModelo(entry: ModeloEntity): Modelo
    fun convertPais(entry: PaisEntity): Pais
    fun convertParentesco(entry: ParentescoEntity): Parentesco
    fun convertTipoConta(entry: TipoContaEntity): TipoConta
    fun convertTipoEmpresa(entry: TipoEmpresaEntity): TipoEmpresa
    fun convertTransporte(entry: TransporteEntity): Transporte
}