package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controller.data.response.ConsultaTransporteResponse;
import com.sevenine.conecta.repository.data.Transporte;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface TransporteMapper {
    List<ConsultaTransporteResponse> fromEntityData(List<Transporte> transportes);
}
