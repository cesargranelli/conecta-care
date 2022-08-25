package com.sevenine.conecta.mapper.cadastro;

import com.sevenine.conecta.controllers.data.request.ContaRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaContaResponse;
import com.sevenine.conecta.repository.data.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CadastraAtualizaContaMapper {

    @Mapping(source = "tipo.id", target = "tipoConta.id")
    @Mapping(source = "proprietarioId", target = "profissional.id")
    Conta toEntityData(ContaRequest request);

    @Mapping(source = "profissional.id", target = "profissionalId")
    CadastraAtualizaContaResponse fromEntityData(Conta conta);

}
