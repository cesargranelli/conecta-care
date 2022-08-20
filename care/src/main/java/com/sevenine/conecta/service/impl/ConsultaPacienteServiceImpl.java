package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.EndpointsPacienteProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.service.data.response.PacienteResponse;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.service.ConsultaPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ConsultaPacienteServiceImpl implements ConsultaPacienteService {

    private final EndpointsPacienteProperties endpointsPacienteProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public PacienteResponse consultar(Long pacienteId) {
        try {
            ResponseEntity<PacienteResponse> responseEntity = restTemplate.exchange(
                    endpointsPacienteProperties.getConsultaPaciente().concat("/").concat(String.valueOf(pacienteId)),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<PacienteResponse>() { }
            );

            return objectMapper.convertValue(responseEntity.getBody(), PacienteResponse.class);
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServicePacienteIndisponivel().concat(" - ").concat(endpointsPacienteProperties.getConsultaPaciente()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

}
