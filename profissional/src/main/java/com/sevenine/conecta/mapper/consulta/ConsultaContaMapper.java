package com.sevenine.conecta.mapper.consulta;

import com.sevenine.conecta.adapter.controller.data.response.ContaResponse;
import com.sevenine.conecta.repository.data.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaContaMapper {

    @Mapping(source = "tipoConta", target = "tipo")
    ContaResponse fromEntityData(Conta conta);

}
