package com.sevenine.conecta.mapper;

import com.sevenine.conecta.controller.data.response.ConsultaInstrucaoResponse;
import com.sevenine.conecta.repository.data.Instrucao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface InstrucaoMapper {
    List<ConsultaInstrucaoResponse> fromEntityData(List<Instrucao> instrucoes);
}
