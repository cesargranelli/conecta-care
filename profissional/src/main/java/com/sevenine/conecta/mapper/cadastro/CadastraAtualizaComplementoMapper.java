package com.sevenine.conecta.mapper.cadastro;

import com.sevenine.conecta.controller.data.request.ComplementoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaComplementoResponse;
import com.sevenine.conecta.repository.data.Complemento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CadastraAtualizaComplementoMapper {

    @Mapping(source = "fotoCNHFrente", target = "fotoCnhFrente")
    @Mapping(source = "fotoCNHVerso", target = "fotoCnhVerso")
    @Mapping(source = "proprietarioId", target = "profissional.id")
    Complemento toEntityData(ComplementoRequest request);

    @Mapping(source = "profissional.id", target = "profissionalId")
    CadastraAtualizaComplementoResponse fromEntityData(Complemento complemento);

}
