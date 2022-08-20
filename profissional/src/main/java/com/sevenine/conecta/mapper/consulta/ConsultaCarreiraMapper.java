package com.sevenine.conecta.mapper.consulta;

import com.sevenine.conecta.controller.data.response.CarreiraResponse;
import com.sevenine.conecta.repository.data.Carreira;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaCarreiraMapper {

    @Mapping(source = "estado", target = "ufConselho")
    @Mapping(source = "areasAtendimento", target = "areasAtendimento")
    CarreiraResponse fromEntityData(Carreira carreira);

}
