package com.sevenine.api.gateway.http;

import com.google.gson.Gson;
import com.sevenine.api.gateway.config.properties.EndpointsProperties;
import com.sevenine.api.gateway.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "dominio/{tipo}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class DominioHttp {

    private final EndpointsProperties urlProperties;

    private final AbstractService abstractService;
    private final Gson gson;

    @GetMapping
    public ResponseEntity<?> getDominioTipo(HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, urlProperties.getConnecta(), HttpMethod.GET);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonArray("data"), Object.class));
    }

}
