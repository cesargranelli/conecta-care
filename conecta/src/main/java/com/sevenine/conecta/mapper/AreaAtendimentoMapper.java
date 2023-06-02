package com.sevenine.conecta.mapper;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaAreaAtendimentoResponse;
import com.sevenine.conecta.repository.data.AreaAtendimento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface AreaAtendimentoMapper {
    List<ConsultaAreaAtendimentoResponse> fromEntityData(List<AreaAtendimento> areasAtendimentos);
}
