package com.sevenine.conecta.mapper.atendimento;

import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.services.data.response.AtendimentoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaListaAtendimentoPacienteServiceMapper {
    List<AtendimentoResponse> fromEntityDataList(List<Atendimento> atendimentos);
}
