package com.connecta.evento.mapper;

import com.connecta.evento.controller.data.request.EventoRequest;
import com.connecta.evento.repository.entity.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "com.connecta.evento.mapper.impl")
public interface EventoCadastraMapper {
    @Mapping(target = "usuarioCadastro", source = "usuario")
    @Mapping(target = "dataCadastro", expression = "java(java.time.LocalDateTime.now())")
    Evento toEntityData(EventoRequest request);
}
