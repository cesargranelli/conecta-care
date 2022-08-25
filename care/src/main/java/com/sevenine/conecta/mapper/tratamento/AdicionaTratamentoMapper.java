package com.sevenine.conecta.mapper.tratamento;

import com.sevenine.conecta.controllers.data.request.tratamento.AdicionaTratamentoRequest;
import com.sevenine.conecta.repository.data.Tratamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface AdicionaTratamentoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "atendimentos", ignore = true)
    @Mapping(target = "situacoes", ignore = true)
    Tratamento toEntityData(AdicionaTratamentoRequest request);

}
