package com.sevenine.conecta.http;

import com.sevenine.conecta.http.resource.EstadoCivilResource;
import com.sevenine.conecta.service.EstadoCivilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/estado-civil")
@RequiredArgsConstructor
public class EstadoCivilHttp {

    private final EstadoCivilService estadoCivilService;

    @GetMapping
    public List<EstadoCivilResource> list() {
        return estadoCivilService.list();
    }

}
