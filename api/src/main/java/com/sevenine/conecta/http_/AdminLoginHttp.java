package com.sevenine.conecta.http_;

import com.google.gson.Gson;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "admin/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class AdminLoginHttp {

    @Value("${url.php.connecta}")
    private String URL_API_PHP;

    private final AbstractService abstractService;
    private final Gson gson;

    @PostMapping
    public ResponseEntity<?> login(HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.POST);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonObject("data"), Object.class));
    }
}
