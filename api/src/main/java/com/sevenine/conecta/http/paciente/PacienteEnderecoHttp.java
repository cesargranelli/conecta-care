package com.sevenine.conecta.http.paciente;

import com.sevenine.conecta.config.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/endereco")
public class PacienteEnderecoHttp {

    private final EndpointsProperties endpointsProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> create(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.POST);
    }

    @PutMapping
    public ResponseEntity<?> edit(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.PUT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.GET);
    }
}
