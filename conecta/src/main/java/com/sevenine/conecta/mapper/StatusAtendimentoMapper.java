package com.sevenine.conecta.mapper;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaStatusAtendimentoResponse;
import com.sevenine.conecta.repository.data.StatusAtendimento;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface StatusAtendimentoMapper {
    List<ConsultaStatusAtendimentoResponse> fromEntityData(List<StatusAtendimento> statusAtendimentos);
}
