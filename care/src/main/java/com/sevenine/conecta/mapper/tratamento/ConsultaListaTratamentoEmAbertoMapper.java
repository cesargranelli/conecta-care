package com.sevenine.conecta.mapper.tratamento;

import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.services.data.response.ConsultaListaTratamentoResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaListaTratamentoEmAbertoMapper {

    @Mapping(target = "status", expression = "java(tratamento.getSituacoes().stream().findFirst().orElse(new com.sevenine.conecta.repository.data.TratamentoSituacao()).getStatus())")
    @Named(value = "fromTratamentoData")
    ConsultaListaTratamentoResponse fromTratamentoData(Tratamento tratamento);

    @IterableMapping(qualifiedByName = "fromTratamentoData")
    List<ConsultaListaTratamentoResponse> fromEntityDataList(List<Tratamento> tratamentos);

}
