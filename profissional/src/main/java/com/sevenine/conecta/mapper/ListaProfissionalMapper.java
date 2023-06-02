package com.sevenine.conecta.mapper;

import com.sevenine.conecta.adapter.controller.data.response.ListaProfissionalResponse;
import com.sevenine.conecta.repository.data.ListaProfissional;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ListaProfissionalMapper {

    @Mapping(target = "foto", source = "fotoProfissional")
    @Mapping(target = "conselho", source = "carreira.conselho.sigla")
    @Mapping(target = "conselhoUf", source = "carreira.estado.uf")
    @Mapping(target = "registro", source = "carreira.registroProfissional")
    @Mapping(target = "celular", source = "telefone.celularPrincipal")
    @Mapping(target = "especialidades", source = "carreira.areasAtendimento")
    @Named(value = "fromEntityData")
    ListaProfissionalResponse fromEntityData(ListaProfissional profissional);

    @IterableMapping(qualifiedByName = "fromEntityData")
    List<ListaProfissionalResponse> fromEntityDataList(List<ListaProfissional> profissionais);

}
