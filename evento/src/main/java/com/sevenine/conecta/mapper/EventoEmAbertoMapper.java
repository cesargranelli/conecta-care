package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controllers.data.response.EventoResponse;
import com.sevenine.conecta.repository.entity.Evento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "com.sevenine.conecta.mapper.impl")
public interface EventoEmAbertoMapper {
    List<EventoResponse> fromEntityData(List<Evento> eventos);
}
