package com.sevenine.conecta.http_;

import com.google.gson.Gson;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "eventos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class AdminEventosHttp {

    @Value("${url.php.connecta}")
    private String URL_API_PHP;

    private final AbstractService abstractService;
    private final Gson gson;

    @PostMapping
    public ResponseEntity<?> add(HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.POST);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonObject("data"), Object.class));
    }

    @GetMapping
    public ResponseEntity<?> list(HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.GET);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonArray("data"), Object.class));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> find(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.GET);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonObject("data"), Object.class));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> send(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.PUT);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonObject("data"), Object.class));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.DELETE);
        return ResponseEntity.ok(gson.fromJson(gson.toJsonTree(response.getBody()).getAsJsonObject().getAsJsonObject("data"), Object.class));
    }

}
