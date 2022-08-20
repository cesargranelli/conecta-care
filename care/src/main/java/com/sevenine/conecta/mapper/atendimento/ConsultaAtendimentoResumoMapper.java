package com.sevenine.conecta.mapper.atendimento;

import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaAtendimentoResumoMapper {

    @Mapping(target = "tratamento", ignore = true)
    List<AtendimentoDetalheResponse> fromListEntityData(List<Atendimento> atendimentos);

}
