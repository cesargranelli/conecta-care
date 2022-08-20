package com.sevenine.conecta.mapper.atendimento;

import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoCheckResponse;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaAtendimentoMapper {

    @Mapping(target = "profissional", ignore = true)
    @Mapping(target = "plantonista", ignore = true)
    @Mapping(target = "tratamento", ignore = true)
    @Mapping(target = "tratamento.id", source = "tratamentoId")
    @Mapping(target = "profissional.id", source = "profissionalId")
    @Mapping(target = "plantonista.id", source = "plantonistaId")
    AtendimentoDetalheResponse fromEntityData(Atendimento atendimento);

    AtendimentoCheckResponse fromEntityToAtendimentoCheck(Atendimento atendimento);

}
