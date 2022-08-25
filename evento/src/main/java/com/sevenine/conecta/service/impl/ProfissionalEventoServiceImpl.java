package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.EndpointsProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.enumerator.Endpoints;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import com.sevenine.conecta.services.ProfissionalEventoService;
import com.sevenine.conecta.services.data.response.ProfissionalEventoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfissionalEventoServiceImpl implements ProfissionalEventoService {

    private final EndpointsProperties endpointsProperties;
    private final ExceptionMessageProperties exceptionMessageProperties;

    private final RestTemplate restTemplate;

    @Override
    public List<ProfissionalEventoResponse> pesquisar(List<Long> idsEspecialidades, Long idEstado) {
        try {
            ResponseEntity<List<ProfissionalEventoResponse>> responseEntity =
                    restTemplate.exchange(
                            endpointsProperties.getEvento().get(Endpoints.FILTRO_DADOS_SMS.getAlias()),
                            HttpMethod.GET,
                            httpEntity(idsEspecialidades, idEstado),
                            new ParameterizedTypeReference<List<ProfissionalEventoResponse>>() { }
                    );
            return responseEntity.getBody();
        } catch (ResourceAccessException e) {
            throw new ServiceIndisponivelException(
                    exceptionMessageProperties.getServiceIndisponivel().concat(" - ").concat(endpointsProperties.getEvento().get(Endpoints.FILTRO_DADOS_SMS.getAlias())),
                    HttpStatus.REQUEST_TIMEOUT
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    private HttpEntity<?> httpEntity(List<Long> idsEspecialidades, Long idEstado) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("especialidades", idsEspecialidades.toString().replace("[", "").replace("]", "").replace(" ", ""));
        headers.set("estado", idEstado.toString());

        return new HttpEntity<>(null, headers);
    }

}
