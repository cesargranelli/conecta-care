package com.sevenine.api.gateway.http.profissional;

import com.sevenine.api.gateway.config.properties.EndpointsProperties;
import com.sevenine.api.gateway.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(path = "profissionais", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class ProfissionalHttp {

    private final EndpointsProperties urlProperties;

    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> save(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.POST);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> find(@PathVariable Long id, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.GET);
    }

    @GetMapping(value = "cpf/{cpf}")
    public ResponseEntity<?> findByCpf(@PathVariable String cpf, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.GET);
    }

    @GetMapping(value = "atendimento")
    public ResponseEntity<?> profissionaisAtendimento(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.GET);
    }

    @GetMapping(value = "completo")
    public ResponseEntity<?> profissionalCompleto(@RequestHeader Long cpf, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.GET);
    }

    @GetMapping(value = "nome")
    public ResponseEntity<?> findByNome(@RequestHeader String nome, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.GET);
    }

}
