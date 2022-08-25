package com.sevenine.conecta.mapper.cadastro;

import com.sevenine.conecta.controllers.data.request.CarreiraRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaCarreiraResponse;
import com.sevenine.conecta.repository.data.Carreira;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CadastraAtualizaCarreiraMapper {

    @Mapping(source = "transporte.id", target = "transporte.id")
    @Mapping(source = "ufConselho.id", target = "estado.id")
    @Mapping(source = "conselho.id", target = "conselho.id")
    @Mapping(source = "proprietarioId", target = "profissional.id")
    Carreira toEntityData(CarreiraRequest request);

    @Mapping(source = "profissional.id", target = "profissionalId")
    CadastraAtualizaCarreiraResponse fromEntityData(Carreira carreira);

    @Mapping(source = "transporte.id", target = "transporte.id")
    @Mapping(source = "ufConselho.id", target = "estado.id")
    @Mapping(source = "conselho.id", target = "conselho.id")
    void updateCarreira(CarreiraRequest request, @MappingTarget Carreira carreira);

}
