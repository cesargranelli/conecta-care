package com.sevenine.conecta.mapper;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalResponse;
import com.sevenine.conecta.repository.data.Profissional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", implementationPackage = "com.sevenine.conecta.mapper.impl")
public interface ProfissionalMapper {

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "rgDataEmissao", source = "rgDataEmissao", dateFormat = "dd/MM/yyyy", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    ProfissionalResponse fromEntityData(Profissional profissional);

}
