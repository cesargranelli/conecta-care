package com.sevenine.conecta.adapter.input.http

import com.sevenine.conecta.domain.model.Especialidade
import com.sevenine.conecta.domain.model.Genero
import com.sevenine.conecta.domain.port.service.DominioServicePort
import com.sevenine.conecta.domain.service.DominioService
import com.sevenine.conecta.domain.service.GeneroService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("dominio")
@RestController
class DominioController(private val services: List<DominioServicePort<Any>>) {

    @GetMapping("especialidades")
    fun especialidades(): ResponseEntity<List<Especialidade>> = ResponseEntity.ok(services
            .filterIsInstance<DominioService>().firstOrNull()?.lista())

    @GetMapping("generos")
    fun generos(): ResponseEntity<List<Genero>> = ResponseEntity.ok(services
            .filterIsInstance<GeneroService>().firstOrNull()?.lista())

}