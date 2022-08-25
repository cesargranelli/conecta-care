package com.sevenine.conecta.mapper.tratamento;

import com.sevenine.conecta.controllers.data.response.tratamento.ProntuarioResponse;
import com.sevenine.conecta.services.data.response.PacienteResponse;
import com.sevenine.conecta.services.data.response.TratamentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaProntuarioMapper {

    @Mapping(target = "paciente", source = "pacienteResponse")
    @Mapping(target = "tratamentos", source = "tratamentosResponse")
    ProntuarioResponse fromServiceResponse(PacienteResponse pacienteResponse, List<TratamentoResponse> tratamentosResponse);

}
