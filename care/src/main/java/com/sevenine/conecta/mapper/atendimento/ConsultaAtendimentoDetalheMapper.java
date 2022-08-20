package com.sevenine.conecta.mapper.atendimento;

import com.sevenine.conecta.controller.data.response.atendimento.ConsultaAtendimentoDetalheResponse;
import com.sevenine.conecta.service.data.response.AcompanhanteResponse;
import com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse;
import com.sevenine.conecta.service.data.response.AtendimentoProfissionalResponse;
import com.sevenine.conecta.service.data.response.PlantonistaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaAtendimentoDetalheMapper {

    @Mapping(target = "id", source = "atendimentoResponse.id")
    @Mapping(target = "dataHora", expression = "java(atendimentoResponse.getData().atTime(atendimentoResponse.getHora()))")
    @Mapping(target = "plantonista", source = "plantonistaResponse")
    @Mapping(target = "acompanhante", source = "acompanhanteResponse")
    @Mapping(target = "profissional", ignore = true)
    @Mapping(target = "profissional.documento", source = "atendimentoProfissionalResponse.cpf")
    @Mapping(target = "profissional.nomeCompleto", expression = "java(atendimentoProfissionalResponse.getNome().concat(\" \").concat(atendimentoProfissionalResponse.getSobrenome()))")
    ConsultaAtendimentoDetalheResponse fromAtendimentoAndProfissional(AtendimentoDetalheResponse atendimentoResponse, PlantonistaResponse plantonistaResponse, AcompanhanteResponse acompanhanteResponse, AtendimentoProfissionalResponse atendimentoProfissionalResponse);

}
