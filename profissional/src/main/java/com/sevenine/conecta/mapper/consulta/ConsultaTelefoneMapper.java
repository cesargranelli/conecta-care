package com.sevenine.conecta.mapper.consulta;

import com.sevenine.conecta.controllers.data.response.TelefoneResponse;
import com.sevenine.conecta.repository.data.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaTelefoneMapper {
    TelefoneResponse fromEntityData(Telefone telefone);
}
