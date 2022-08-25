package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsConnectaProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controllers.data.response.GeneroResponse;
import com.sevenine.conecta.exception.GeneroNaoLocalizadoException;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.services.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class GeneroServiceImpl implements GeneroService {

    private final EndpointsConnectaProperties endpointsConnectaProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public GeneroResponse consultar(Long idGenero) {
        try {
            ResponseEntity<List<GeneroResponse>> responseEntity = restTemplate.exchange(
                    endpointsConnectaProperties.getDominioGenero(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<GeneroResponse>>() {
                    }
            );
            return filtrarGenero(responseEntity.getBody(), idGenero);
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceIndisponivel().concat(" - ").concat(endpointsConnectaProperties.getDominioGenero()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    private GeneroResponse filtrarGenero(List<GeneroResponse> generos, Long idGenero) {
        return Objects.requireNonNull(generos).stream()
                .filter(genero -> genero.getId().equals(idGenero))
                .findAny()
                .orElseThrow(() -> new GeneroNaoLocalizadoException(
                        exceptionMessageProperties.getGeneroNaoLocalizado(),
                        HttpStatus.NOT_FOUND
                ));
    }

}
