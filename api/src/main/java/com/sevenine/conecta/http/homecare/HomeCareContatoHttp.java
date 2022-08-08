package com.sevenine.conecta.http.homecare;

import com.sevenine.conecta.config.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "homecares/{idHomeCare}/contatos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class HomeCareContatoHttp {

    private final EndpointsProperties urlProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> cadastro(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getHomeCare(), HttpMethod.POST);
    }

    @PutMapping
    public ResponseEntity<?> alteracao(@PathVariable Long idHomeCare, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getHomeCare(), HttpMethod.PUT);
    }

    @GetMapping
    public ResponseEntity<?> consulta(@PathVariable Long idHomeCare, HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getHomeCare(), HttpMethod.GET);
    }

}
