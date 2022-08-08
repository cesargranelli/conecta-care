package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controller.data.response.ConsultaGrupoResponse;
import com.sevenine.conecta.repository.data.Grupo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface GrupoMapper {
    List<ConsultaGrupoResponse> fromEntityData(List<Grupo> grupos);
}
