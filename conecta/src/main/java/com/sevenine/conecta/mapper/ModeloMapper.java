package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controller.data.response.ConsultaModeloResponse;
import com.sevenine.conecta.repository.data.Modelo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ModeloMapper {
    List<ConsultaModeloResponse> fromEntityData(List<Modelo> modelos);
}
