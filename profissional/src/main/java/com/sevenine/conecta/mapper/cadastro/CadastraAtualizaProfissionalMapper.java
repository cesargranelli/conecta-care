package com.sevenine.conecta.mapper.cadastro;

import com.sevenine.conecta.controllers.data.request.ProfissionalRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaProfissionalResponse;
import com.sevenine.conecta.repository.data.Profissional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CadastraAtualizaProfissionalMapper {

    @Mapping(source = "genero", target = "genero.id")
    @Mapping(source = "tipoEmpresa", target = "tipoEmpresa.id")
    @Mapping(source = "estadoCivil", target = "estadoCivil.id")
    Profissional toEntityData(ProfissionalRequest request);

    @Mapping(source = "id", target = "profissionalId")
    CadastraAtualizaProfissionalResponse fromEntityData(Profissional profissional);

}
