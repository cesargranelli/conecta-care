package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controller.data.response.ConsultaEstadoResponse;
import com.sevenine.conecta.repository.data.Estado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface EstadoMapper {
    List<ConsultaEstadoResponse> fromEntityData(List<Estado> estados);
}
