package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controllers.data.response.ConsultaGeneroResponse;
import com.sevenine.conecta.repositories.entities.GeneroData;
import com.sevenine.conecta.services.output.GeneroOutput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface GeneroMapper {

    GeneroMapper INSTANCE = Mappers.getMapper(GeneroMapper.class);

    List<ConsultaGeneroResponse> fromEntityData(List<GeneroData> generos);

    List<ConsultaGeneroResponse> toResponse(List<GeneroOutput> generos);

}
