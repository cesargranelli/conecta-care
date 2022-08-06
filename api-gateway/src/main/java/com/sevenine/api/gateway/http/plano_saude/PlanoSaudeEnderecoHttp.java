package com.sevenine.api.gateway.http.plano_saude;

import com.sevenine.api.gateway.config.properties.EndpointsProperties;
import com.sevenine.api.gateway.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "planos-saude/{idPlanoSaude}/enderecos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PlanoSaudeEnderecoHttp {

    private final EndpointsProperties urlProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> cadastro(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getPlanoSaude(), HttpMethod.POST);
    }

    @PutMapping
    public ResponseEntity<?> alteracao(@PathVariable Long idPlanoSaude, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getPlanoSaude(), HttpMethod.PUT);
    }

    @GetMapping
    public ResponseEntity<?> consulta(@PathVariable Long idPlanoSaude, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getPlanoSaude(), HttpMethod.GET);
    }

}
