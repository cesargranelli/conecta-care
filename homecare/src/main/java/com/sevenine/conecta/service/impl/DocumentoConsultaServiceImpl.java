package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.EndpointsConnectaProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.InformacaoNaoLocalizadaException;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.service.DocumentoConsultaService;
import com.sevenine.conecta.service.data.response.DocumentoResponse;
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
public class DocumentoConsultaServiceImpl implements DocumentoConsultaService {

    private final EndpointsConnectaProperties endpointsConnectaProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public DocumentoResponse consultar(Long documentoId) {
        try {
            ResponseEntity<DocumentoResponse> responseEntity = restTemplate.exchange(
                    endpointsConnectaProperties.getConsultaDocumento().concat("/").concat(String.valueOf(documentoId)),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<DocumentoResponse>() { }
            );

            return objectMapper.convertValue(responseEntity.getBody(), DocumentoResponse.class);
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceConnectaIndisponivel().concat(" - ").concat(endpointsConnectaProperties.getConsultaDocumento()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new InformacaoNaoLocalizadaException(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
