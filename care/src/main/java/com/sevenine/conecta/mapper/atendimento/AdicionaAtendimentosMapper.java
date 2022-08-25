package com.sevenine.conecta.mapper.atendimento;

import com.sevenine.conecta.controllers.data.request.atendimento.AdicionaAtendimentoRequest;
import com.sevenine.conecta.repository.data.Atendimento;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface AdicionaAtendimentosMapper {

    @Mapping(target = "situacoes", ignore = true)
    @Mapping(target = "procedimento", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "codigoSeguranca", expression = "java(atendimento.geraCodigoSeguranca())")
    @Named(value = "toEntityData")
    Atendimento toEntityData(AdicionaAtendimentoRequest request);

    @IterableMapping(qualifiedByName = "toEntityData")
    List<Atendimento> toEntityDataList(List<AdicionaAtendimentoRequest> requests);

}
