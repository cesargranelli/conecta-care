package com.sevenine.api.gateway.http.care;

import com.sevenine.api.gateway.config.properties.EndpointsProperties;
import com.sevenine.api.gateway.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping(path = "atendimentos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AtendimentoHttp {

    private final EndpointsProperties urlProperties;
    private final AbstractService abstractService;

    @PostMapping
    public ResponseEntity<?> adiciona(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.POST);
    }

    @GetMapping("resumo")
    public ResponseEntity<?> resumo(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @GetMapping("{atendimentoId}")
    public ResponseEntity<?> atendimento(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @GetMapping("profissional")
    public ResponseEntity<?> atendimentoProfissional(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @GetMapping("profissional/check")
    public ResponseEntity<?> atendimentoCheck(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @PostMapping("status")
    public ResponseEntity<?> criaStatus(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.POST);
    }

    @PutMapping("baixa")
    public ResponseEntity<?> baixaAtendimento(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.PUT);
    }

    @GetMapping("paciente")
    public ResponseEntity<?> atendimentosPaciente(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @GetMapping("preview")
    public ResponseEntity<?> preview(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getCare(), HttpMethod.GET);
    }

    @GetMapping(value = "preview/file", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> previewPdf(HttpServletRequest request) {
        return abstractService.abstractRequestOctetStream(request, urlProperties.getCare(), HttpMethod.GET);
    }

}
