package com.sevenine.conecta.http.usuarios;

import com.sevenine.conecta.http.care.config.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class UsuarioHttp {

    private final EndpointsProperties urlProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> add(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getAuthentication(), HttpMethod.POST);
    }

    @GetMapping
    public ResponseEntity<?> find(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getAuthentication(), HttpMethod.GET);
    }

    @PutMapping(value = "validacao")
    public ResponseEntity<?> valid(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getAuthentication(), HttpMethod.PUT);
    }

    @PutMapping(value = "ativacao")
    public ResponseEntity<?> active(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getAuthentication(), HttpMethod.PUT);
    }

}
