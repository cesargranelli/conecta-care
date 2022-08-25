package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsPacienteProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.services.data.response.PacienteResponse;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.services.ConsultaListaPacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultaListaPacienteServiceImpl implements ConsultaListaPacienteService {

    private final EndpointsPacienteProperties endpointsPacienteProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public List<PacienteResponse> consultar(List<Long> pacienteIdList) {
        try {
            ResponseEntity<List<PacienteResponse>> responseEntity = restTemplate.exchange(
                    endpointsPacienteProperties.getConsultaPaciente().concat("/lista"),
                    HttpMethod.GET,
                    httpEntity(pacienteIdList),
                    new ParameterizedTypeReference<List<PacienteResponse>>() { }
            );

            return responseEntity.getBody();
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

    private HttpEntity<?> httpEntity(List<Long> pacienteIdList) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("pacientes", pacienteIdList.toString().replace("[", "").replace("]", "").replace(" ", ""));

        return new HttpEntity<>(null, headers);
    }

}
