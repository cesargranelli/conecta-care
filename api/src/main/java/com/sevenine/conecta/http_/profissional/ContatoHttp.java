package com.sevenine.conecta.http_.profissional;

import com.sevenine.conecta.http_.care.config.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "contatos/telefones", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class ContatoHttp {

    private final EndpointsProperties urlProperties;

    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> sendTelefone(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.POST);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getTelefone(@PathVariable Long id, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.GET);
    }

}
