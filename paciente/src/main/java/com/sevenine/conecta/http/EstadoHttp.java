package com.sevenine.conecta.http;

import com.sevenine.conecta.http.resource.EstadoResource;
import com.sevenine.conecta.service.EstadoService;
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
