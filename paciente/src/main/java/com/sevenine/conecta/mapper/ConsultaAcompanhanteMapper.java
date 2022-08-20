package com.sevenine.conecta.mapper;

import com.sevenine.conecta.http.resource.AcompanhanteResponseResource;
import com.sevenine.conecta.repository.entity.AcompanhanteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaAcompanhanteMapper {
    AcompanhanteResponseResource fromEntityData(AcompanhanteEntity acompanhante);

    List<AcompanhanteResponseResource> fromEntityDataList(List<AcompanhanteEntity> acompanhantes);
}
