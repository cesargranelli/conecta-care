package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsProfissionalProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.services.ConsultaListaProfissionalService;
import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultaListaProfissionalServiceImpl implements ConsultaListaProfissionalService {

    private final EndpointsProfissionalProperties endpointsProfissionalProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public List<AtendimentoProfissionalResponse> consultar(List<Long> profissionaisIds) {

        try {
            ResponseEntity<List<AtendimentoProfissionalResponse>> responseEntity = restTemplate.exchange(
                    endpointsProfissionalProperties.getConsultaProfissional(),
                    HttpMethod.GET,
                    httpEntity(profissionaisIds),
                    new ParameterizedTypeReference<List<AtendimentoProfissionalResponse>>() { }
            );

            return responseEntity.getBody();
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceProfissionalIndisponivel().concat(" - ").concat(endpointsProfissionalProperties.getConsultaProfissional()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    private HttpEntity<?> httpEntity(List<Long> profissionaisIds) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("profissionais", profissionaisIds.toString().replace("[", "").replace("]", "").replace(" ", ""));

        return new HttpEntity<>(null, headers);
    }

}
