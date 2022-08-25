package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controllers.data.response.EventoResponse;
import com.sevenine.conecta.repository.entity.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationPackage = "com.sevenine.conecta.mapper.impl")
public interface EventoConsultaMapper {
    EventoResponse fromEntityData(Evento evento);
}
