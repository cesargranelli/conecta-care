package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.EndpointsHomeCareProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.service.ConsultaListaPlantonistaService;
import com.sevenine.conecta.service.data.response.PlantonistaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultaListaPlantonistaServiceImpl implements ConsultaListaPlantonistaService {

    private final EndpointsHomeCareProperties endpointsHomeCareProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public List<PlantonistaResponse> consultar(List<Long> plantonistasIds) {
        try {
            ResponseEntity<List<PlantonistaResponse>> responseEntity = restTemplate.exchange(
                    endpointsHomeCareProperties.getConsultaPlantonista(),
                    HttpMethod.GET,
                    httpEntity(plantonistasIds),
                    new ParameterizedTypeReference<List<PlantonistaResponse>>() { }
            );

            return responseEntity.getBody();
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceHomeCareIndisponivel().concat(" - ").concat(endpointsHomeCareProperties.getConsultaPlantonista()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    private HttpEntity<?> httpEntity(List<Long> plantonistaIdList) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("plantonistas", plantonistaIdList.toString().replace("[", "").replace("]", "").replace(" ", ""));

        return new HttpEntity<>(null, headers);
    }

}
