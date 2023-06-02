package com.sevenine.conecta.mapper;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaTipoContaResponse;
import com.sevenine.conecta.repository.data.TipoConta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface TipoContaMapper {
    List<ConsultaTipoContaResponse> fromEntityData(List<TipoConta> tiposContas);
}
