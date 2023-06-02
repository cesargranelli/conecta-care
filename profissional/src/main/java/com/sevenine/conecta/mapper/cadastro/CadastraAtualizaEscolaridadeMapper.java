package com.sevenine.conecta.mapper.cadastro;

import com.sevenine.conecta.adapter.controller.data.request.EscolaridadeRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaEscolaridadeResponse;
import com.sevenine.conecta.repository.data.Escolaridade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CadastraAtualizaEscolaridadeMapper {

    @Mapping(target = "instituicaoEnsino", expression = "java(request.getInstituicaoEnsino().stream().map(String::toString).collect(java.util.stream.Collectors.joining(\"\\\",\\\"\", \"[\\\"\", \"\\\"]\")))")
    @Mapping(target = "anoConclusao", expression = "java(request.getAnoConclusao().stream().map(String::toString).collect(java.util.stream.Collectors.joining(\"\\\",\\\"\", \"[\\\"\", \"\\\"]\")))")
    @Mapping(source = "instrucao.id", target = "instrucao.id", ignore = true)
    @Mapping(source = "proprietarioId", target = "profissional.id")
    Escolaridade toEntityData(EscolaridadeRequest request);

    @Mapping(source = "profissional.id", target = "profissionalId")
    CadastraAtualizaEscolaridadeResponse fromEntityData(Escolaridade escolaridade);

    @Mapping(target = "instituicaoEnsino", expression = "java(request.getInstituicaoEnsino().stream().map(String::toString).collect(java.util.stream.Collectors.joining(\"\\\",\\\"\", \"[\\\"\", \"\\\"]\")))")
    @Mapping(target = "anoConclusao", expression = "java(request.getAnoConclusao().stream().map(String::toString).collect(java.util.stream.Collectors.joining(\"\\\",\\\"\", \"[\\\"\", \"\\\"]\")))")
    @Mapping(target = "instrucao", ignore = true)
    void updateEscolaridade(EscolaridadeRequest request, @MappingTarget Escolaridade escolaridade);

}
