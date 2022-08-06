package com.sevenine.api.gateway.http.paciente;

import com.sevenine.api.gateway.config.properties.EndpointsProperties;
import com.sevenine.api.gateway.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tipo-sanguineo")
public class PacienteTipoSanguineoHttp {

    private final EndpointsProperties endpointsProperties;
    private final AbstractService abstractService;

    @GetMapping
    public ResponseEntity<?> get(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.GET);
    }
}
