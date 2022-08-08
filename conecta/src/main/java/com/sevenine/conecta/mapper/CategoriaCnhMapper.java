package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controller.data.response.ConsultaCategoriaCnhResponse;
import com.sevenine.conecta.repository.data.CategoriaCnh;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CategoriaCnhMapper {
    List<ConsultaCategoriaCnhResponse> fromEntityData(List<CategoriaCnh> categoriasCnh);
}
