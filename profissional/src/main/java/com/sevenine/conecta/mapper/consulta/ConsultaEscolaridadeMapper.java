package com.sevenine.conecta.mapper.consulta;

import com.sevenine.conecta.adapter.controller.data.response.EscolaridadeResponse;
import com.sevenine.conecta.repository.data.Escolaridade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaEscolaridadeMapper {

    @Mapping(target = "instituicaoEnsino", expression = "java(java.util.Arrays.asList(org.springframework.util.StringUtils.commaDelimitedListToStringArray(escolaridade.getInstituicaoEnsino().replaceAll(\"[\\\\[\\\\]\\\"]\", \"\"))))")
    @Mapping(target = "anoConclusao", expression = "java(java.util.Arrays.asList(org.springframework.util.StringUtils.commaDelimitedListToStringArray(escolaridade.getAnoConclusao().replaceAll(\"[\\\\[\\\\]\\\"]\", \"\"))))")
    EscolaridadeResponse fromEntityData(Escolaridade escolaridade);

}
