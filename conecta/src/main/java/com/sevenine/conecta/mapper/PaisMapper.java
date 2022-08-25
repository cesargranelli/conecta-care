package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controllers.data.response.ConsultaPaisResponse;
import com.sevenine.conecta.repository.data.Pais;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface PaisMapper {
    List<ConsultaPaisResponse> fromEntityData(List<Pais> paises);
}
