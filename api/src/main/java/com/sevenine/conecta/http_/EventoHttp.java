package com.sevenine.conecta.http_;

import com.sevenine.conecta.http_.response.HyperMediaResponse;
import com.sevenine.conecta.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RequestMapping(value = "profissionais/{idProfissional}/eventos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class EventoHttp {

    @Value("${url.php.connecta}")
    private String URL_API_PHP;

    private final AbstractService abstractService;

    @DeleteMapping(value = "{idEvento}")
    public Object deleteEvento(@PathVariable Long idProfissional, @PathVariable Long idEvento, HttpServletRequest request) {
        HyperMediaResponse hyperMediaResponse = (HyperMediaResponse)
                abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.DELETE).getBody();
        return Objects.requireNonNull(hyperMediaResponse).getData();
    }

    @PutMapping(value = "{idEvento}")
    public Object editEvento(@PathVariable Long idProfissional, @PathVariable Long idEvento, HttpServletRequest request) {
        HyperMediaResponse hyperMediaResponse = (HyperMediaResponse)
                abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.PUT).getBody();
        return Objects.requireNonNull(hyperMediaResponse).getData();
    }

    @GetMapping
    public Object getEventosByProfissional(@PathVariable Long id, HttpServletRequest request) {
        HyperMediaResponse hyperMediaResponse = (HyperMediaResponse)
                abstractService.abstractRequest(request, URL_API_PHP, HttpMethod.GET).getBody();
        return Objects.requireNonNull(hyperMediaResponse).getData();
    }

}
