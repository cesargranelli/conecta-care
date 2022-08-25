package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controllers.resource.AcompanhanteResource;
import com.sevenine.conecta.controllers.resource.AcompanhanteResponseResource;
import com.sevenine.conecta.repository.entity.AcompanhanteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface AdicionaAcompanhanteMapper {

    @Mapping(target = "id", ignore = true)
    AcompanhanteEntity toEntityData(AcompanhanteResource acompanhante);

    @Mapping(target = "nomeCompleto", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    @Mapping(target = "dataNascimento", ignore = true)
    @Mapping(target = "genero", ignore = true)
    @Mapping(target = "parentesco", ignore = true)
    @Mapping(target = "contato", ignore = true)
    AcompanhanteResponseResource fromEntityData(AcompanhanteEntity acompanhante);

}
