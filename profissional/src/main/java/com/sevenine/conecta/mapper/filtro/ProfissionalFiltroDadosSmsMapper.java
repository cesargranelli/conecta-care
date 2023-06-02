package com.sevenine.conecta.mapper.filtro;//package com.sevenine.conecta.mapper.filtro;
//
//import com.sevenine.conecta.adapter.controller.data.response.ProfissionalFiltroDadosSmsResponse;
//import com.sevenine.conecta.repository.data.Profissional;
//import org.mapstruct.IterableMapping;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring", implementationPackage = "com.sevenine.conecta.mapper.filtro.impl")
//public interface ProfissionalFiltroDadosSmsMapper {
//
//    @Mapping(target = "profissionalId", source = "id")
//    @Mapping(target = "numeroTelefone", source = "telefone.celularPrincipal")
//    @Named("fromEntityData")
//    ProfissionalFiltroDadosSmsResponse fromEntityData(Profissional profissional);
//
//    @IterableMapping(qualifiedByName = "fromEntityData")
//    List<ProfissionalFiltroDadosSmsResponse> fromListEntityData(List<Profissional> profissional);
//
//}
