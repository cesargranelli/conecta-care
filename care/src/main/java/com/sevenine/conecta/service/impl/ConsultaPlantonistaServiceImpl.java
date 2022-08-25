package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsHomeCareProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.services.ConsultaPlantonistaService;
import com.sevenine.conecta.services.data.response.PlantonistaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ConsultaPlantonistaServiceImpl implements ConsultaPlantonistaService {

    private final EndpointsHomeCareProperties endpointsHomeCareProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public PlantonistaResponse consultar(Long homeCareId, Long plantonistaId) {
        try {
            ResponseEntity<PlantonistaResponse> responseEntity = restTemplate.exchange(
                    endpointsHomeCareProperties.getConsultaPlantonista().concat("/").concat(String.valueOf(plantonistaId)),
                    HttpMethod.GET,
                    httpEntity(homeCareId),
                    new ParameterizedTypeReference<PlantonistaResponse>() { }
            );
            if (responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
                return new PlantonistaResponse();
            }
            return objectMapper.convertValue(responseEntity.getBody(), PlantonistaResponse.class);
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceHomeCareIndisponivel().concat(" - ").concat(endpointsHomeCareProperties.getConsultaPlantonista()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new PlantonistaResponse();
        }
    }

    private static HttpEntity<?> httpEntity(Long homeCareId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("homeCareId", homeCareId.toString());
        return new HttpEntity<>(null, httpHeaders);
    }

}
