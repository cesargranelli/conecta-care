package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controller.data.response.ConsultaGeneroResponse;
import com.sevenine.conecta.repository.data.Genero;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface GeneroMapper {
    List<ConsultaGeneroResponse> fromEntityData(List<Genero> generos);
}
