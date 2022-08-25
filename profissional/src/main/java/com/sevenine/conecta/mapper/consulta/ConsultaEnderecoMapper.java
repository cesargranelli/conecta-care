package com.sevenine.conecta.mapper.consulta;

import com.sevenine.conecta.controllers.data.response.EnderecoResponse;
import com.sevenine.conecta.repository.data.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaEnderecoMapper {
    EnderecoResponse fromEntityData(Endereco endereco);
}
