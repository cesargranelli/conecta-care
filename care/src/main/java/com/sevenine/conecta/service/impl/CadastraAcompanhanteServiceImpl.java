package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.EndpointsPacienteProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controller.data.request.tratamento.AdicionaAcompanhanteRequest;
import com.sevenine.conecta.exception.FalhaCadastroAcompanhanteException;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.service.CadastraAcompanhanteService;
import com.sevenine.conecta.service.data.response.AcompanhanteResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class CadastraAcompanhanteServiceImpl implements CadastraAcompanhanteService {

    private final EndpointsPacienteProperties endpointsPacienteProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public Long cadastrar(AdicionaAcompanhanteRequest request) {
        try {
            ResponseEntity<AcompanhanteResponse> responseEntity = restTemplate.exchange(
                    endpointsPacienteProperties.getCadastraAcompanhante(),
                    HttpMethod.POST,
                    httpEntity(request),
                    new ParameterizedTypeReference<AcompanhanteResponse>() {
                    }
            );

            return objectMapper.convertValue(responseEntity.getBody(), AcompanhanteResponse.class).getId();
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServicePacienteIndisponivel().concat(" - ").concat(endpointsPacienteProperties.getCadastraAcompanhante()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new FalhaCadastroAcompanhanteException(e.getLocalizedMessage(), HttpStatus.PRECONDITION_REQUIRED);
        }
    }

    private static HttpEntity<?> httpEntity(AdicionaAcompanhanteRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(request, httpHeaders);
    }

}
