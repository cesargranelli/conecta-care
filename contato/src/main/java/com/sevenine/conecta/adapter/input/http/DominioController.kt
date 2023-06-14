package com.sevenine.conecta.adapter.input.http

import com.sevenine.conecta.adapter.output.persistence.*
import com.sevenine.conecta.domain.model.*
import com.sevenine.conecta.domain.port.service.DominioServicePort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("dominios")
@RestController
class DominioController(private val service: DominioServicePort) {

    @GetMapping("especialidade")
    fun especialidades(): ResponseEntity<List<Especialidade>> = ResponseEntity.ok(service
            .listaEspecialidades())

    @GetMapping("genero")
    fun generos(): ResponseEntity<List<Genero>> = ResponseEntity.ok(service
            .listaGeneros())

    @GetMapping("banco")
    fun bancos(): ResponseEntity<List<Banco>> = ResponseEntity.ok(service
            .listaBancos())

    @GetMapping("categoria-cnh")
    fun categoriasCnh(): ResponseEntity<List<CategoriaCnh>> = ResponseEntity.ok(service
            .listaCategoriasCnh())

    @GetMapping("conselho")
    fun conselhos(): ResponseEntity<List<Conselho>> = ResponseEntity.ok(service
            .listaConselhos())

    @GetMapping("estado")
    fun estados(): ResponseEntity<List<Estado>> = ResponseEntity.ok(service
            .listaEstados())

    @GetMapping("estado-civil")
    fun estadosCivil(): ResponseEntity<List<EstadoCivil>> = ResponseEntity.ok(service
            .listaEstadosCivis())

    @GetMapping("grupo")
    fun grupos(): ResponseEntity<List<Grupo>> = ResponseEntity.ok(service
            .listaGrupos())

    @GetMapping("instrucao")
    fun instrucoes(): ResponseEntity<List<Instrucao>> = ResponseEntity.ok(service
            .listaInstrucoes())

    @GetMapping("modelo")
    fun modelos(): ResponseEntity<List<Modelo>> = ResponseEntity.ok(service
            .listaModelos())

    @GetMapping("pais")
    fun paises(): ResponseEntity<List<Pais>> = ResponseEntity.ok(service
            .listaPaises())

    @GetMapping("parentesco")
    fun parentescos(): ResponseEntity<List<Parentesco>> = ResponseEntity.ok(service
            .listaParentescos())

    @GetMapping("tipo-conta")
    fun tiposConta(): ResponseEntity<List<TipoConta>> = ResponseEntity.ok(service
            .listaTiposConta())

    @GetMapping("tipo-empresa")
    fun tiposEmpresa(): ResponseEntity<List<TipoEmpresa>> = ResponseEntity.ok(service
            .listaTiposEsmpresa())

    @GetMapping("transporte")
    fun transportes(): ResponseEntity<List<Transporte>> = ResponseEntity.ok(service
            .listaTransportes())

}