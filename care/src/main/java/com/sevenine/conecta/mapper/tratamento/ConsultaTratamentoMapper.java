package com.sevenine.conecta.mapper.tratamento;

import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.services.data.response.AtendimentoDetalheResponse;
import com.sevenine.conecta.services.data.response.TratamentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaTratamentoMapper {

    @Mapping(target = "tratamento", ignore = true)
    @Mapping(target = "profissional.id", source = "profissionalId")
    @Mapping(target = "plantonista.id", source = "plantonistaId")
    @Named(value = "fromAtendimentoData")
    AtendimentoDetalheResponse fromAtendimentoData(Atendimento atendimento);

    @Mapping(target = "atendimentos", qualifiedByName = "fromAtendimentoData")
    @Mapping(target = "paciente.id", source = "pacienteId")
    @Mapping(target = "acompanhante.id", source = "acompanhanteId")
    @Mapping(target = "profissional.id", source = "profissionalId")
    @Mapping(target = "homeCare.id", source = "homeCareId")
    TratamentoResponse fromEntityData(Tratamento tratamento);

}
