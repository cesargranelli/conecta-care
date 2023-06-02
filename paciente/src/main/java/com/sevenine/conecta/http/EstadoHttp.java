package com.sevenine.conecta.adapter.controller;

import com.sevenine.conecta.adapter.controller.resource.EstadoResource;
import com.sevenine.conecta.services.EstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/estado")
@RequiredArgsConstructor
public class EstadoHttp {

    private final EstadoService estadoService;

    @GetMapping
    public List<EstadoResource> list() {
        return estadoService.list();
    }

}
