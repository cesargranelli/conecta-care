package com.sevenine.conecta.mapper.filtro;//package com.sevenine.conecta.mapper.filtro;
//
//import com.sevenine.conecta.adapter.controller.data.response.ProfissionalResponse;
//import com.sevenine.conecta.repository.data.Profissional;
//import org.mapstruct.IterableMapping;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring", implementationPackage = "com.sevenine.conecta.mapper.filtro.impl")
//public interface ProfissionalFiltroEspecialidadeMapper {
//
//    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
//    @Named("fromEntityData")
//    ProfissionalResponse fromEntityData(Profissional profissional);
//
//    @IterableMapping(qualifiedByName = "fromEntityData")
//    List<ProfissionalResponse> fromListEntityData(List<Profissional> profissional);
//
//}
