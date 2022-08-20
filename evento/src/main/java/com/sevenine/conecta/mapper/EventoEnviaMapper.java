package com.connecta.evento.mapper;

import com.connecta.evento.controller.data.response.EnvioResponse;
import com.connecta.evento.service.data.request.EventoEnviaRequest;
import com.connecta.evento.service.data.response.ProfissionalEventoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "com.connecta.evento.mapper.impl")
public interface EventoEnviaMapper {
    List<EventoEnviaRequest> toRequest(List<ProfissionalEventoResponse> profissionaisEvento);

    EnvioResponse fromQuantidadeEnviados(Integer quantidadeEnviados);
}
