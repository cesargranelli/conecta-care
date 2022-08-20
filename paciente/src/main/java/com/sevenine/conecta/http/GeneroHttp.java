package com.sevenine.conecta.http;

import com.sevenine.conecta.http.resource.GeneroResource;
import com.sevenine.conecta.service.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/genero")
@RequiredArgsConstructor
public class GeneroHttp {

    private final GeneroService generoService;

    @GetMapping
    public List<GeneroResource> list() {
        return generoService.list();
    }

}
