package com.sevenine.conecta.mapper.cadastro;

import com.sevenine.conecta.adapter.controller.data.request.TelefoneRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaTelefoneResponse;
import com.sevenine.conecta.repository.data.Telefone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CadastraAtualizaTelefoneMapper {

    @Mapping(source = "proprietarioId", target = "profissional.id")
    Telefone toEntityData(TelefoneRequest request);

    @Mapping(source = "profissional.id", target = "profissionalId")
    CadastraAtualizaTelefoneResponse fromEntityData(Telefone telefone);

    void updateTelefone(TelefoneRequest request, @MappingTarget Telefone telefone);

}
