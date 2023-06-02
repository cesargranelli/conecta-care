package com.sevenine.conecta.mapper;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaEstadoCivilResponse;
import com.sevenine.conecta.repository.data.EstadoCivil;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface EstadoCivilMapper {
    List<ConsultaEstadoCivilResponse> fromEntityData(List<EstadoCivil> estadosCivis);
}
