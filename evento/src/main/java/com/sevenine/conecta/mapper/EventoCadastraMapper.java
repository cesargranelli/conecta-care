package com.sevenine.conecta.mapper;

import com.sevenine.conecta.adapter.controller.data.request.EventoRequest;
import com.sevenine.conecta.repository.entity.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "com.sevenine.conecta.mapper.impl")
public interface EventoCadastraMapper {
    @Mapping(target = "usuarioCadastro", source = "usuario")
    @Mapping(target = "dataCadastro", expression = "java(java.time.LocalDateTime.now())")
    Evento toEntityData(EventoRequest request);
}
