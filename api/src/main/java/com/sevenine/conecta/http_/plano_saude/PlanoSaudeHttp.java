package com.sevenine.conecta.http_.plano_saude;

import com.sevenine.conecta.http_.care.config.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "planos-saude", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PlanoSaudeHttp {

    private final EndpointsProperties urlProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> cadastro(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getPlanoSaude(), HttpMethod.POST);
    }

    @PutMapping
    public ResponseEntity<?> alteracao(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getPlanoSaude(), HttpMethod.PUT);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> consulta(@PathVariable Long id, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getPlanoSaude(), HttpMethod.GET);
    }

    @GetMapping("matriz")
    public ResponseEntity<?> listarMatriz(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getPlanoSaude(), HttpMethod.GET);
    }

}
