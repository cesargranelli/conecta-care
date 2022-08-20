package com.sevenine.conecta.http_;

import com.sevenine.conecta.configs.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping(path = "tratamentos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class TratamentoHttp {

    private final EndpointsProperties urlProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> adiciona(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.POST);
    }

    @GetMapping("prontuario")
    public ResponseEntity<?> prontuario(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> consulta(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @GetMapping("aberto")
    public ResponseEntity<?> listaEmAberto(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @GetMapping("aberto/paciente")
    public ResponseEntity<?> emAbertoPaciente(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @PutMapping("encerramento")
    public ResponseEntity<?> encerramento(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.PUT);
    }

}
