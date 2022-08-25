package com.sevenine.conecta.controllers;

import com.sevenine.conecta.controllers.resource.TipoSanguineoResource;
import com.sevenine.conecta.services.TipoSanguineoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tipo-sanguineo")
@RequiredArgsConstructor
public class TipoSanguineoHttp {

    private final TipoSanguineoService tipoSanguineoService;

    @GetMapping
    public List<TipoSanguineoResource> list() {
        return tipoSanguineoService.list();
    }

}
