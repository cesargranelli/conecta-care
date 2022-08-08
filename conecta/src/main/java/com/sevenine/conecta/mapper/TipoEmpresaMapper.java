package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controller.data.response.ConsultaTipoEmpresaResponse;
import com.sevenine.conecta.repository.data.TipoEmpresa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface TipoEmpresaMapper {
    List<ConsultaTipoEmpresaResponse> fromEntityData(List<TipoEmpresa> tiposEmpresas);
}
