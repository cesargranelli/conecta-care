package com.sevenine.api.gateway.http.profissional;

import com.sevenine.api.gateway.config.properties.EndpointsProperties;
import com.sevenine.api.gateway.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "enderecos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class EnderecoHttp {

    private final EndpointsProperties urlProperties;

    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> sendEndereco(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.POST);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getEndereco(@PathVariable Long id, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getProfissional(), HttpMethod.GET);
    }

}
