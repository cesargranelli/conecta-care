package com.sevenine.conecta.mapper;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaBancoResponse;
import com.sevenine.conecta.repository.data.Banco;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface BancoMapper {
    List<ConsultaBancoResponse> fromEntityData(List<Banco> bancos);
}
