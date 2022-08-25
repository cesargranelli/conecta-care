package com.sevenine.conecta.mapper.consulta;

import com.sevenine.conecta.controllers.data.response.ExperienciaResponse;
import com.sevenine.conecta.repository.data.Experiencia;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaExperienciaMapper {

    @Named(value = "fromEntityData")
    ExperienciaResponse fromEntityData(Experiencia experiencia);

    @IterableMapping(qualifiedByName = "fromEntityData")
    List<ExperienciaResponse> fromEntityDataList(List<Experiencia> experiencia);

}
