package com.connecta.evento.mapper;

import com.connecta.evento.controller.data.response.EventoResponse;
import com.connecta.evento.repository.entity.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationPackage = "com.connecta.evento.mapper.impl")
public interface EventoConsultaMapper {
    EventoResponse fromEntityData(Evento evento);
}
