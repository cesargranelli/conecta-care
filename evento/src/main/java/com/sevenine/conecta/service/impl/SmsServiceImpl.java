package com.connecta.evento.service.impl;

import com.connecta.evento.config.properties.ApplicationProperties;
import com.connecta.evento.config.properties.EndpointsProperties;
import com.connecta.evento.config.properties.ExceptionMessageProperties;
import com.connecta.evento.enumerator.Endpoints;
import com.connecta.evento.exception.ServiceIndisponivelException;
import com.connecta.evento.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SmsServiceImpl implements SmsService {

    private final ApplicationProperties properties;
    private final EndpointsProperties endpointsProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public void enviar(Long profissionalId, String numeroTelefone) {
        try {
            restTemplate.exchange(
                    endpointsProperties.getSms().get(Endpoints.ENVIO_ABERTO.getAlias()),
                    HttpMethod.GET,
                    null,
                    Void.class,
                    uriVariables(numeroTelefone, profissionalId)
            );
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceIndisponivel().concat(" - ").concat(endpointsProperties.getSms().get(Endpoints.ENVIO_ABERTO.getAlias())),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    private Map<String, String> uriVariables(String numeroTelefone, Long idProfissional) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", properties.getClienteSms());
        uriVariables.put("fn", numeroTelefone);
        uriVariables.put("sms", endpointsProperties.getEvento().get(Endpoints.CONFIRMA_EVENTO.getAlias()).replace("{id}", idProfissional.toString()));

        return uriVariables;
    }

}
