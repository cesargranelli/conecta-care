package com.sevenine.conecta.mapper.cadastro;

import com.sevenine.conecta.controllers.data.request.EnderecoRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaEnderecoResponse;
import com.sevenine.conecta.repository.data.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CadastraAtualizaEnderecoMapper {

    @Mapping(target = "profissional", ignore = true)
    @Mapping(target = "profissional.id", source = "proprietarioId")
    @Mapping(target = "estado.id", source = "estado")
    @Mapping(target = "pais.id", source = "pais")
    Endereco toEntityData(EnderecoRequest request);

    @Mapping(source = "profissional.id", target = "profissionalId")
    CadastraAtualizaEnderecoResponse fromEntityData(Endereco endereco);

}
