package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsConnectaProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.adapter.controller.data.response.EstadoCivilResponse;
import com.sevenine.conecta.exception.EstadoCivilNaoLocalizadoException;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.services.EstadoCivilService;
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
public class EstadoCivilServiceImpl implements EstadoCivilService {

    private final EndpointsConnectaProperties endpointsConnectaProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public EstadoCivilResponse consultar(Long idEstadoCivil) {
        try {
            ResponseEntity<List<EstadoCivilResponse>> responseEntity = restTemplate.exchange(
                    endpointsConnectaProperties.getDominioEstadoCivil(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<EstadoCivilResponse>>() {
                    }
            );
            return filtrarEstadoCivil(responseEntity.getBody(), idEstadoCivil);
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceIndisponivel().concat(" - ").concat(endpointsConnectaProperties.getDominioEstadoCivil()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    private EstadoCivilResponse filtrarEstadoCivil(List<EstadoCivilResponse> estadosCivis, Long idEstadoCivil) {
        return Objects.requireNonNull(estadosCivis).stream()
                .filter(estadoCivil -> estadoCivil.getId().equals(idEstadoCivil))
                .findAny()
                .orElseThrow(() -> new EstadoCivilNaoLocalizadoException(
                        exceptionMessageProperties.getEstadoCivilNaoLocalizado(),
                        HttpStatus.NOT_FOUND
                ));
    }

}
