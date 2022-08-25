package com.sevenine.conecta.mapper.atendimento;

import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.services.data.response.AtendimentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaListaAtendimentoProfissionalServiceMapper {

    @Mapping(target = "recorrencia", ignore = true)
    AtendimentoResponse fromEntityData(Atendimento atendimento);

}
