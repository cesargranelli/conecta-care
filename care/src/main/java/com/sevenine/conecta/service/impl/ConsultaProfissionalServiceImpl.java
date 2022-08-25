package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsProfissionalProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.services.ConsultaProfissionalService;
import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ConsultaProfissionalServiceImpl implements ConsultaProfissionalService {

    private final EndpointsProfissionalProperties endpointsProfissionalProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public AtendimentoProfissionalResponse consultar(Long profissionalId) {
        try {
            ResponseEntity<List<AtendimentoProfissionalResponse>> responseEntity = restTemplate.exchange(
                    endpointsProfissionalProperties.getConsultaProfissional(),
                    HttpMethod.GET,
                    httpEntity(profissionalId),
                    new ParameterizedTypeReference<List<AtendimentoProfissionalResponse>>() {
                    }
            );

            return objectMapper.convertValue(Objects.requireNonNull(responseEntity.getBody()).get(0), AtendimentoProfissionalResponse.class);
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServicePacienteIndisponivel().concat(" - ").concat(endpointsProfissionalProperties.getConsultaProfissional()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new NaoLocalizadoException(e.getLocalizedMessage(), HttpStatus.NO_CONTENT);
        }
    }

    private HttpEntity<?> httpEntity(Long profissionalId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.set("profissionais", String.valueOf(profissionalId));

        return new HttpEntity<>(null, headers);
    }

}
