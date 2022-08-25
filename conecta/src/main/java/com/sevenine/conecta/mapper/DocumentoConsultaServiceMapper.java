package com.sevenine.conecta.mapper;

import com.sevenine.conecta.services.data.response.DocumentoResponse;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface DocumentoConsultaServiceMapper {
    DocumentoResponse fromEntityData(SequenceCadastro orElseThrow);
}
