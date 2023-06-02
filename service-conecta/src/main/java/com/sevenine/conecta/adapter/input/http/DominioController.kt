package com.sevenine.conecta.adapter.input.http

import com.sevenine.conecta.domain.model.Especialidade
import com.sevenine.conecta.domain.service.EspecialidadeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("dominio")
@RestController
class DominioController(private val especialidadeService: EspecialidadeService) {

    @GetMapping("especialidades")
    fun especialidades(): List<Especialidade> {
        return especialidadeService.executa()
    }

}