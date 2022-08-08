package com.sevenine.conecta.http.profissional;

import com.sevenine.conecta.http.response.HyperMediaResponse;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RequestMapping(value = "profissionais/registrar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class RegistrarHttp {

    @Value("${url.php.connecta}")
    private String URL_API_PHP;

    private final AbstractService abstractService;

    @PostMapping
    public Object registrar(HttpServletRequest request) {
        HyperMediaResponse hyperMediaResponse = (HyperMediaResponse)
                abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.POST).getBody();
        return Objects.requireNonNull(hyperMediaResponse).getData();
    }

}
