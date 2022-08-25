package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controllers.data.response.ConsultaParentescoResponse;
import com.sevenine.conecta.repository.data.Parentesco;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ParentescoMapper {
    List<ConsultaParentescoResponse> fromEntityData(List<Parentesco> parentescos);
}
