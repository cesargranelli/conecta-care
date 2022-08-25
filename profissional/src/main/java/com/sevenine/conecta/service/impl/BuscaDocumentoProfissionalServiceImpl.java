package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsConnectaProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.services.BuscaDocumentoProfissionalService;
import com.sevenine.conecta.services.data.response.DocumentoResponse;
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
public class BuscaDocumentoProfissionalServiceImpl implements BuscaDocumentoProfissionalService {

    private final EndpointsConnectaProperties endpointsConnectaProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public String buscar(Long documentoId) {
        try {
            ResponseEntity<DocumentoResponse> responseEntity = restTemplate.exchange(
                    endpointsConnectaProperties.getConsultaDocumento().concat("/").concat(String.valueOf(documentoId)),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<DocumentoResponse>() {
                    }
            );

            DocumentoResponse documentoResponse =
                    objectMapper.convertValue(responseEntity.getBody(), DocumentoResponse.class);

            return documentoResponse.getDocumento();
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceIndisponivel().concat(" - ").concat(endpointsConnectaProperties.getConsultaDocumento()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

}
