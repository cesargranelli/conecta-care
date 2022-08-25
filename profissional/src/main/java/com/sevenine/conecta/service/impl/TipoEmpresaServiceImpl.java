package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsConnectaProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controllers.data.response.TipoEmpresaResponse;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.exception.TipoEmpresaNaoLocalizadoException;
import com.sevenine.conecta.services.TipoEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TipoEmpresaServiceImpl implements TipoEmpresaService {

    private final EndpointsConnectaProperties endpointsConnectaProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public TipoEmpresaResponse consultar(Long idTipoEmpresa) {
        try {
            ResponseEntity<List<TipoEmpresaResponse>> responseEntity = restTemplate.exchange(
                    endpointsConnectaProperties.getDominioTipoEmpresa(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<TipoEmpresaResponse>>() {
                    }
            );
            return filtrarTipoEmpresa(responseEntity.getBody(), idTipoEmpresa);
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceIndisponivel().concat(" - ").concat(endpointsConnectaProperties.getDominioTipoEmpresa()),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    private TipoEmpresaResponse filtrarTipoEmpresa(List<TipoEmpresaResponse> tiposEmpresas, Long idTipoEmpresa) {
        return Objects.requireNonNull(tiposEmpresas).stream()
                .filter(tipoEmpresa -> tipoEmpresa.getId().equals(idTipoEmpresa))
                .findAny()
                .orElseThrow(() -> new TipoEmpresaNaoLocalizadoException(
                        exceptionMessageProperties.getTipoEmpresaNaoLocalizado(),
                        HttpStatus.NOT_FOUND
                ));
    }

}
