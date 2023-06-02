package com.sevenine.conecta.adapter.input.http

import com.sevenine.conecta.domain.model.Especialidade
import com.sevenine.conecta.domain.service.EspecialidadeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("dominio")
@RestController
class DominioController(private val especialidadeService: EspecialidadeService) {

    @GetMapping("especialidades")
    fun especialidades(): ResponseEntity<List<Especialidade>> {
        return ResponseEntity.ok(especialidadeService.lista())
    }

}