package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.EndpointsPacienteProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.service.ConsultaAcompanhanteService;
import com.sevenine.conecta.service.data.response.AcompanhanteResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class ConsultaAcompanhanteServiceImpl implements ConsultaAcompanhanteService {

    private final EndpointsPacienteProperties endpointsPacienteProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public AcompanhanteResponse consultar(Long pacienteId, Long acompanhanteId) {
        if (isNull(acompanhanteId)) return null;
        try {
            ResponseEntity<AcompanhanteResponse> responseEntity = restTemplate.exchange(
                    endpointsPacienteProperties.getConsultaAcompanhante().concat("/").concat(String.valueOf(acompanhanteId)),
                    HttpMethod.GET,
                    httpEntity(pacienteId),
                    new ParameterizedTypeReference<AcompanhanteResponse>() { }
            );

            return objectMapper.convertValue(responseEntity.getBody(), AcompanhanteResponse.class);
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServicePacienteIndisponivel().concat(" - ").concat(endpointsPacienteProperties.getConsultaAcompanhante()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new NaoLocalizadoException(e.getLocalizedMessage(), HttpStatus.NO_CONTENT);
        }
    }

    private static HttpEntity<?> httpEntity(Long homeCareId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("pacienteId", homeCareId.toString());
        return new HttpEntity<>(null, httpHeaders);
    }

}
