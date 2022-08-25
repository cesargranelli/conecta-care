package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controllers.data.response.ConsultaConselhoResponse;
import com.sevenine.conecta.repository.data.Conselho;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConselhoMapper {
    List<ConsultaConselhoResponse> fromEntityData(List<Conselho> conselhos);
}
