package com.sevenine.conecta.http_.paciente;

import com.sevenine.conecta.http_.care.config.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/paciente")
public class PacienteHttp {

    private final EndpointsProperties endpointsProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> create(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.POST);
    }

    @PutMapping
    public ResponseEntity<?> update(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.PUT);
    }

    @GetMapping(params = "documento")
    public ResponseEntity<?> getByCpf(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.GET);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.GET);
    }

    @GetMapping(params = "nome")
    public ResponseEntity<?> getByNome(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.GET);
    }

    @GetMapping(path = "lista")
    public ResponseEntity<?> getPacientes(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.GET);
    }

    @GetMapping(path = "cpf")
    public ResponseEntity<?> findByCpf(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.GET);
    }

    @GetMapping(path = "listaCpf")
    public ResponseEntity<?> getCpfListByName(HttpServletRequest request) {
        return abstractService.abstractRequest(request, this.endpointsProperties.getPaciente(), HttpMethod.GET);
    }

}
