package com.sevenine.conecta.http_.login;

import com.google.gson.Gson;
import com.sevenine.conecta.http_.care.config.properties.EndpointsProperties;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LoginHttp {

    //    @Value("${url.services.authentication}") TODO: habilitar após finalizar implementação do token e refresh token
    @Value("${url.php.connecta}")
    private String URL_SERVICE_AUTHENTICATION;

    private final EndpointsProperties urlProperties;
    private final AbstractService abstractService;
    private final Gson gson;

    @PostMapping
    public ResponseEntity<?> login(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getAuthentication(), HttpMethod.POST);
    }

    @GetMapping
    public ResponseEntity<?> find(HttpServletRequest request) {
        return abstractService.abstractRequest(request, urlProperties.getAuthentication(), HttpMethod.GET);
    }

    @PostMapping(value = "esqueci-minha-senha")
    public ResponseEntity<?> esqueciMinhaSenha(HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, URL_SERVICE_AUTHENTICATION, HttpMethod.POST);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonObject("data"), Object.class));
    }

    @PostMapping(value = "nova-senha")
    public ResponseEntity<?> novaSenha(HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, URL_SERVICE_AUTHENTICATION, HttpMethod.POST);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonObject("data"), Object.class));
    }

}
