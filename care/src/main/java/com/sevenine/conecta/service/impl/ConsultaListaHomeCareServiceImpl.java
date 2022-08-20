package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.EndpointsHomeCareProperties;
import com.sevenine.conecta.config.properties.EndpointsPacienteProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.service.ConsultaListaHomeCareService;
import com.sevenine.conecta.service.data.response.HomeCareResponse;
import com.sevenine.conecta.service.data.response.PacienteResponse;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ConsultaListaHomeCareServiceImpl implements ConsultaListaHomeCareService {

    private final EndpointsHomeCareProperties endpointsHomeCareProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public List<HomeCareResponse> consultar() {

        try {
            ResponseEntity<List<HomeCareResponse>> responseEntity = restTemplate.exchange(
                    endpointsHomeCareProperties.getConsulta(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<HomeCareResponse>>() { }
            );

            return responseEntity.getBody();
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServicePacienteIndisponivel().concat(" - ").concat(endpointsHomeCareProperties.getConsulta()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }

}
