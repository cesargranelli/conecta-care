package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsAuthenticationProperties;
import com.sevenine.conecta.services.AtivaUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class AtivaUsuarioServiceImpl implements AtivaUsuarioService {

    private final EndpointsAuthenticationProperties properties;

    private final RestTemplate restTemplate;

    @Override
    public void ativar(Long idHomeCare) {
        try {
            restTemplate.exchange(
                    properties.getUsuarioAtivacao(),
                    HttpMethod.PUT,
                    httpEntity(idHomeCare),
                    Void.class
            );
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static HttpEntity<?> httpEntity(Long idHomeCare) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("sequenceCadastroId", idHomeCare.toString());
        return new HttpEntity<>(null, httpHeaders);
    }

}
