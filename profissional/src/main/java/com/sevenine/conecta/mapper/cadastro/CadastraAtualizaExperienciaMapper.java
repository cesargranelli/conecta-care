package com.sevenine.conecta.mapper.cadastro;

import com.sevenine.conecta.adapter.controller.data.request.ExperienciaRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaExperienciaResponse;
import com.sevenine.conecta.repository.data.Experiencia;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CadastraAtualizaExperienciaMapper {

    @Named(value = "toEntityData")
    @Mapping(source = "profissionalId", target = "profissional.id")
    Experiencia toEntityData(ExperienciaRequest request);

    @IterableMapping(qualifiedByName = "toEntityData")
    List<Experiencia> toEntityDataList(List<ExperienciaRequest> request);

    CadastraAtualizaExperienciaResponse fromEntityData(Long profissionalId);

}
