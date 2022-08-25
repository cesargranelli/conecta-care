package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controllers.data.response.EnvioResponse;
import com.sevenine.conecta.services.data.request.EventoEnviaRequest;
import com.sevenine.conecta.services.data.response.ProfissionalEventoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "com.sevenine.conecta.mapper.impl")
public interface EventoEnviaMapper {
    List<EventoEnviaRequest> toRequest(List<ProfissionalEventoResponse> profissionaisEvento);

    EnvioResponse fromQuantidadeEnviados(Integer quantidadeEnviados);
}
