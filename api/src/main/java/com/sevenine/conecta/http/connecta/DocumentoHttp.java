package com.sevenine.conecta.http.connecta;

import com.sevenine.conecta.config.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "documentos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class DocumentoHttp {

    private final EndpointsProperties urlProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> add(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getConnecta(), HttpMethod.POST);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> find(@PathVariable String id, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getConnecta(), HttpMethod.GET);
    }

}
